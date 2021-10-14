package com.pjboy.riddler_reserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.mapper.GoodsMapper;
import com.pjboy.riddler_reserve.model.GoodsDO;
import com.pjboy.riddler_reserve.model.vo.GoodsVO;
import com.pjboy.riddler_reserve.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

  @Autowired
  private GoodsMapper goodsMapper;

  @Override
  public int addGoods(GoodsDO goodsDO) {
    return goodsMapper.insert(goodsDO);
  }

  @Override
  public int deleteGoodsById(Integer goodsId) {
    return goodsMapper.deleteById(goodsId);
  }

  @Override
  public int deleteGoodsByIds(List<Integer> ids) {
    return goodsMapper.deleteBatchIds(ids);
  }

  @Override
  public int updateGoods(GoodsDO goodsDO) {
    return goodsMapper.updateById(goodsDO);
  }

  @Override
  public GoodsDO selectGoodsById(Integer goodsId) {
    return goodsMapper.selectById(goodsId);
  }

  @Override
  public GoodsDO selectGoodsByName(String name) {
    QueryWrapper<GoodsDO> wrapper = new QueryWrapper<>();
    wrapper.eq("name", name);
    return goodsMapper.selectOne(wrapper);
  }

  @Override
  public IPage<GoodsVO> selectGoodsPage(Page<?> page, String goodsName, Date createTimeStart, Date createTimeEnd) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String Start = null, End = null;
    if (createTimeStart != null) Start = sdf.format(createTimeStart);
    if (createTimeEnd != null) End = sdf.format(createTimeEnd);
    return goodsMapper.selectGoodsPage(page, goodsName, Start, End);
  }
}
