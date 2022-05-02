package com.pjboy.riddler_reserve.controller.v1.front;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.controller.util.SnowFlake;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.GoodsDO;
import com.pjboy.riddler_reserve.model.OrderDO;
import com.pjboy.riddler_reserve.model.OrderGroupDO;
import com.pjboy.riddler_reserve.model.RoundDO;
import com.pjboy.riddler_reserve.model.vo.GoodsVO;
import com.pjboy.riddler_reserve.model.vo.OrderVO;
import com.pjboy.riddler_reserve.service.GoodsService;
import com.pjboy.riddler_reserve.service.OrderGroupService;
import com.pjboy.riddler_reserve.service.OrderService;
import com.pjboy.riddler_reserve.service.RoundService;
import com.pjboy.riddler_reserve.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/front/orders")
public class OrderFrontController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderGroupService orderGroupService;

    @Autowired
    private RoundService roundService;

    @PostMapping("")
    public AjaxResponse addOrder(@RequestBody OrderDO orderDO) {
        BasicCheck.checkRole("users");
        String AddError = "添加订单失败！";
        String FullError = "该场次已经满人了！";
        String ExistError = "你已经在组局里了！";
        OrderGroupDO orderGroupDO = orderGroupService.findOrderGroupById(orderDO.getOrderGroup());
        if (orderGroupDO != null) {
            Integer userId = BasicCheck.getLoginId();
            if (orderService.checkOrderIsFull(orderGroupDO.getId(), orderGroupDO.getGoodsId()))
                return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, FullError);
            if (orderService.checkOrderIsExist(userId, orderGroupDO.getId()))
                return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ExistError);
            SnowFlake snowFlake = new SnowFlake(2, 3);
            orderDO.setOrderId(String.valueOf(snowFlake.nextId()));
            orderDO.setOrderPrice(orderGroupDO.getPackagePrice());
            orderDO.setOrderState(0);
            orderDO.setUserId(userId);
            if (orderService.addOrder(orderDO)) return AjaxResponse.success();
        }
        return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, AddError);
    }

    @GetMapping("/showMyOrders")
    public AjaxResponse showMyOrders(
            @RequestParam(value = "size") Integer pageSize,
            @RequestParam(value = "page") Integer currentPage,
            @RequestParam(required = false) String goodsName
    ) {
        BasicCheck.checkRole("users");
        Page<GoodsVO> page = new Page<>(currentPage, pageSize);
        Integer userId = BasicCheck.getLoginId();
        IPage<OrderVO> orderVOIPageList = orderService.getOrderVOByUserId(page, userId, goodsName);
        if (orderVOIPageList != null) return AjaxResponse.success(orderVOIPageList);
        return AjaxResponse.success();
    }

    @DeleteMapping("/{id}")
    public AjaxResponse deleteOrderById(
            @PathVariable Integer id
    ) {
        BasicCheck.checkRole("users");
        Integer loginId = BasicCheck.getLoginId();
        OrderDO orderDO = orderService.getOrderById(id);
        if (!Objects.equals(orderDO.getUserId(), loginId)) {
            return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "该订单不是您的，无法删除！");
        } else {
            OrderGroupDO orderGroupDO = orderGroupService.findOrderGroupById(orderDO.getOrderGroup());
            if (orderGroupDO != null) {
                RoundDO roundDO = roundService.selectRoundById(orderGroupDO.getRoundId());
                if (roundDO != null) {
                    try {
                        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd ");
                        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");

                        String playDateString = formatterDate.format(orderGroupDO.getPlayTime());
                        String playTimeString = formatterTime.format(roundDO.getStartTime());
                        String playDateTimeString = playDateString + playTimeString;

                        if (new Date().getTime() > TimeUtils.headDate(playDateTimeString, 3).getTime()) {
                            return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "该订单已经超出可以取消的时间范围内了！");
                        } else if (orderService.deleteOrderById(id)) // 执行删除订单
                            return AjaxResponse.success();
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, "在处理日期的时候发生错误，请联系管理员！");
                    }
                }
            }
        }
        return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, "系统发生错误，请联系管理员！");
    }
}
