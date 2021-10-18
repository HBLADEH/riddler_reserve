package com.pjboy.riddler_reserve.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.mapper.OrderGroupMapper;
import com.pjboy.riddler_reserve.model.OrderGroupDO;
import com.pjboy.riddler_reserve.model.vo.OrderGroupVO;
import com.pjboy.riddler_reserve.service.OrderGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderGroupServiceImpl implements OrderGroupService {
  @Autowired
  private OrderGroupMapper orderGroupMapper;
  @Override
  public IPage<OrderGroupVO> selectOrderGroupPage(Page<?> page, String goodsName, Date createTimeStart, Date createTimeEnd) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String Start = null, End = null;
    if (createTimeStart != null) Start = sdf.format(createTimeStart);
    if (createTimeEnd != null) End = sdf.format(createTimeEnd);
    return orderGroupMapper.selectOrderGroupPage(page,goodsName,Start,End);
  }

  @Override
  public int addOrderGroup(OrderGroupDO orderGroupDO) {
    return orderGroupMapper.insert(orderGroupDO);
  }

  @Override
  public int updateOrderGroup(OrderGroupDO orderGroupDO) {
    return orderGroupMapper.updateById(orderGroupDO);
  }

  @Override
  public int deleteOrderGroupByIds(List<Integer> ids) {
    return orderGroupMapper.deleteBatchIds(ids);
  }

  @Override
  public OrderGroupVO findOrderGroupById(Integer id) {
    return orderGroupMapper.findOrderGroupById(id);
  }
}
