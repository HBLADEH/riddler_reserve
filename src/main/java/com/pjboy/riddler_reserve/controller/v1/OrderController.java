package com.pjboy.riddler_reserve.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.vo.OrderVO;
import com.pjboy.riddler_reserve.service.OrderService;
import com.pjboy.riddler_reserve.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/main")
    public AjaxResponse listMainOrders(@RequestParam
                                       @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
                                       @RequestParam
                                       @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {
        List<OrderVO> mainOrders = orderService.listOrdersByDate(startTime, endTime);
        if (mainOrders != null) {
            return AjaxResponse.success(mainOrders);
        }
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "查询预约失败!");
    }


    @GetMapping("/listAll")
    public AjaxResponse orderListAll(
            @RequestParam(value = "size") Integer pageSize,
            @RequestParam(value = "page") Integer currentPage,
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime,
            @RequestParam(required = false)
                    String userName
    ) {
        BasicCheck.checkRole("admin");
        Page<OrderVO> page = new Page<>(currentPage, pageSize);
        IPage<OrderVO> orderVOIPage = orderService.getOrderListAll(page, startTime, endTime, userName);
        if (orderVOIPage != null) return AjaxResponse.success(orderVOIPage);
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "查询预约失败!");
    }


}
