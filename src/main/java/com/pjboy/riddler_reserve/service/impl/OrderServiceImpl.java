package com.pjboy.riddler_reserve.service.impl;

import com.pjboy.riddler_reserve.mapper.OrderMapper;
import com.pjboy.riddler_reserve.model.OrderDO;
import com.pjboy.riddler_reserve.model.vo.OrderVO;
import com.pjboy.riddler_reserve.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderMapper orderMapper;

  @Override
  public OrderDO getOrderById(Integer id) {
    return orderMapper.selectById(id);
  }

  @Override
  public List<OrderVO> listOrdersByDate(Date startTime, Date endTime) {
    return orderMapper.listOrdersByDate(startTime, endTime);
  }
}
