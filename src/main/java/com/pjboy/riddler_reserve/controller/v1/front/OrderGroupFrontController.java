package com.pjboy.riddler_reserve.controller.v1.front;

import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.front.view.OrderGroupPlayerView;
import com.pjboy.riddler_reserve.model.vo.OrderGroupVO;
import com.pjboy.riddler_reserve.service.OrderGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/front/orderGroups")
public class OrderGroupFrontController {

    @Autowired
    private OrderGroupService orderGroupService;

    @GetMapping("/searchFrom")
    public AjaxResponse searchFrom(
            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date playTime,
            @RequestParam(required = false) String goodsName,
            @RequestParam(required = false) String roomName,
            @RequestParam(required = false) String roundName
    ) {
//        BasicCheck.checkRole("users");
//        String ErrorEmpty = "未查询到组局信息!";
        List<OrderGroupPlayerView> orderGroupPlayerViews = orderGroupService.listOrderGroupsByFront(playTime, goodsName, roomName, roundName);
        if (orderGroupPlayerViews != null) return AjaxResponse.success(orderGroupPlayerViews);
        return AjaxResponse.success();
//        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
    }
}