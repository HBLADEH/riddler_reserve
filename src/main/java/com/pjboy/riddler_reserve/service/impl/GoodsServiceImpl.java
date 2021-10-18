package com.pjboy.riddler_reserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.mapper.GoodsMapper;
import com.pjboy.riddler_reserve.model.GoodsDO;
import com.pjboy.riddler_reserve.model.GoodsPackageDO;
import com.pjboy.riddler_reserve.model.vo.GoodsFromVO;
import com.pjboy.riddler_reserve.model.vo.GoodsVO;
import com.pjboy.riddler_reserve.service.GoodsPackageService;
import com.pjboy.riddler_reserve.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

  @Autowired
  private GoodsMapper goodsMapper;

  @Autowired
  private GoodsPackageService goodsPackageService;

  /**
   * @Description: 添加商品
   * @Param: [goodsFromVO]
   * @return: int
   * @Author: BLADE
   * @Date: 2021/10/15
   */
  @Override
  public int addGoods(GoodsFromVO goodsFromVO) {
    GoodsDO goodsDO = goodsFromVO.getGoods();
    int goodsRes = goodsMapper.insert(goodsDO);
    if (goodsRes > 0) {
      List<GoodsPackageDO> packageList = goodsFromVO.getPackageList();
      packageList.forEach(t -> {
        t.setGoodsId(goodsDO.getId());
      });
      /* 添加套餐 */
      goodsPackageService.saveBatch(goodsFromVO.getPackageList());
    }
    return goodsRes;
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
  public int updateGoods(GoodsFromVO goodsFromVO) {
    GoodsDO goodsDO = goodsFromVO.getGoods();
    int goodsRes = goodsMapper.updateById(goodsDO);
    if (goodsRes > 0) {
      Map<String, Object> map = new HashMap<>();
      map.put("goods_id", goodsDO.getId());
      goodsPackageService.removeByMap(map);
      List<GoodsPackageDO> packageList = goodsFromVO.getPackageList();
      packageList.forEach(t -> {
        t.setGoodsId(goodsDO.getId());
      });
      goodsPackageService.saveBatch(packageList);
    }
    return goodsRes;
  }

  @Override
  public GoodsFromVO selectGoodsById(Integer goodsId) {
    GoodsDO goodsDO = goodsMapper.selectById(goodsId);
    if (goodsDO != null) {
      Map<String, Object> map = new HashMap<>();
      map.put("goods_id", goodsDO.getId());
      List<GoodsPackageDO> packageList = goodsPackageService.listByMap(map);
      return new GoodsFromVO(goodsDO, packageList);
    }
    return null;
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
