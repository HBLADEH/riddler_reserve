package com.pjboy.riddler_reserve.controller.v1;

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
@RequestMapping("/v1")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @GetMapping("/orders/main")
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

}
