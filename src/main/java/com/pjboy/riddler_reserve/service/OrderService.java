package com.pjboy.riddler_reserve.service;

import com.pjboy.riddler_reserve.model.OrderDO;
import com.pjboy.riddler_reserve.model.vo.OrderVO;

import java.util.Date;
import java.util.List;

public interface OrderService {
  OrderDO getOrderById(Integer id);
  List<OrderVO> listOrdersByDate(Date startTime,Date endTime);
}
