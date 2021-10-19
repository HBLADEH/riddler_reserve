package com.pjboy.riddler_reserve.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.model.OrderGroupDO;
import com.pjboy.riddler_reserve.model.vo.OrderGroupVO;

import java.util.Date;
import java.util.List;

public interface OrderGroupService {
  /**
   * @Description: 获取组局分页数据
   * @Param: [分页对象, 商品名称, 创建时间起点, 创建时间重点]
   * @return: 组局分页数据
   * @Author: BLADE
   * @Date: 2021/10/18
   */
  IPage<OrderGroupVO> selectOrderGroupPage(Page<?> page, String goodsName, Date playTimeStart, Date playTimeEnd);

  int addOrderGroup(OrderGroupDO orderGroupDO);

  int updateOrderGroup(OrderGroupDO orderGroupDO);

  int deleteOrderGroupByIds(List<Integer> ids);

  OrderGroupVO findOrderGroupById(Integer id);

}
