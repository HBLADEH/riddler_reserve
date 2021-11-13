package com.pjboy.riddler_reserve.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.OrderGroupDO;
import com.pjboy.riddler_reserve.model.vo.OrderGroupVO;
import com.pjboy.riddler_reserve.service.OrderGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class OrderGroupController {
    @Autowired
    private OrderGroupService orderGroupService;

    @GetMapping("/orderGroups/listAll")
    public AjaxResponse selectOrderGroupByList(@RequestParam(value = "size") Integer pageSize,
                                               @RequestParam(value = "page") Integer currentPage,
                                               @RequestParam(required = false) String goodsName,
                                               @RequestParam(required = false)
                                               @DateTimeFormat(pattern = "yyyy-MM-dd") Date playTimeStart,
                                               @RequestParam(required = false)
                                               @DateTimeFormat(pattern = "yyyy-MM-dd") Date playTimeEnd) {
        BasicCheck.checkRole("admin");
        String ErrorEmpty = "未查询到组局信息!";
        Page<OrderGroupDO> page = new Page<>(currentPage, pageSize);
        IPage<OrderGroupVO> orderGroupIPage = orderGroupService.selectOrderGroupPage(page, goodsName, playTimeStart, playTimeEnd);
        if (orderGroupIPage != null) return AjaxResponse.success(orderGroupIPage);
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
    }

    @PostMapping("/orderGroups")
    public AjaxResponse addOrderGroup(@RequestBody OrderGroupDO orderGroupDO) {
        BasicCheck.checkRole("admin");
        String ErrorInsert = "添加组局信息失败!";
        String ErrorGoodsIsExist = "该商品在设定的游玩时间和场次上并不空闲！";
        String ErrorRoomsIsExist = "该房间在设定的游玩时间和场次上并不空闲！";
        if (orderGroupService.checkGoodsIsFree(orderGroupDO))
            return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorGoodsIsExist);
        if (orderGroupService.checkRoomsIsFree(orderGroupDO))
            return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorRoomsIsExist);
        if (orderGroupService.addOrderGroup(orderGroupDO) > 0) return AjaxResponse.success();
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorInsert);
    }

    @PutMapping("/orderGroups")
    public AjaxResponse updateOrderGroup(@RequestBody OrderGroupDO orderGroupDO) {
        BasicCheck.checkRole("admin");
        String ErrorEdit = "修改组局信息失败!";
        String ErrorGoodsIsExist = "该商品在设定的游玩时间和场次上并不空闲！";
        String ErrorRoomsIsExist = "该房间在设定的游玩时间和场次上并不空闲！";
        if (orderGroupService.checkGoodsIsFree(orderGroupDO))
            return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorGoodsIsExist);
        if (orderGroupService.checkRoomsIsFree(orderGroupDO))
            return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorRoomsIsExist);
        if (orderGroupService.updateOrderGroup(orderGroupDO) > 0) return AjaxResponse.success();
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEdit);
    }

    @DeleteMapping("/orderGroups")
    public AjaxResponse deleteOrderGroup(@RequestBody List<Integer> ids) {
        BasicCheck.checkRole("admin");
        String ErrorDelete = "删除组局信息失败!";
        if (orderGroupService.deleteOrderGroupByIds(ids) > 0) return AjaxResponse.success();
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorDelete);
    }

    @GetMapping("/orderGroups/{id}")
    public AjaxResponse findOrderGroupById(@PathVariable Integer id) {
        BasicCheck.checkRole("admin");
        String ErrorSelect = "未查询到组局信息!";
        OrderGroupDO orderGroupDO = orderGroupService.findOrderGroupById(id);
        if (orderGroupDO != null) return AjaxResponse.success(orderGroupDO);
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorSelect);
    }


    @GetMapping("/orderGroups/main")
    public AjaxResponse listMainOrderGroups(@RequestParam
                                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
                                            @RequestParam
                                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {
        List<OrderGroupVO> mainOrderGroups = orderGroupService.listOrderGroupsByDate(startTime, endTime);
        return AjaxResponse.success(mainOrderGroups);
    }



}
