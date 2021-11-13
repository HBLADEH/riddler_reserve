package com.pjboy.riddler_reserve.controller.v1.front;

import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.controller.util.SnowFlake;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.GoodsDO;
import com.pjboy.riddler_reserve.model.OrderDO;
import com.pjboy.riddler_reserve.model.OrderGroupDO;
import com.pjboy.riddler_reserve.service.GoodsService;
import com.pjboy.riddler_reserve.service.OrderGroupService;
import com.pjboy.riddler_reserve.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/front/orders")
public class OrderFrontController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderGroupService orderGroupService;

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

}
