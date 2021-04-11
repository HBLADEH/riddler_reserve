package com.pjboy.riddler_reserve.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.model.GoodsDO;

import java.util.Date;
import java.util.List;

public interface GoodsService {
  int addGoods(GoodsDO goodsDO);

  int deleteGoodsById(Integer goodsId);

  int updateGoods(GoodsDO goodsDO);

  GoodsDO selectGoodsById(Integer goodsId);

  GoodsDO selectGoodsByName(String name);

  /**
   * <p>
   * 查询 : 根据state状态查询商品列表，分页显示
   * </p>
   *
   * @param page  分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
   * @param goodsName 名称
   * @param createTimeStart 创建时间起点
   * @param createTimeEnd 创建时间终点
   * @return 分页对象
   */
  IPage<GoodsDO> selectGoodsPage(Page<?> page, String goodsName, Date createTimeStart, Date createTimeEnd);

}