package com.pjboy.riddler_reserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pjboy.riddler_reserve.mapper.GoodsPackageMapper;
import com.pjboy.riddler_reserve.model.GoodsPackageDO;
import com.pjboy.riddler_reserve.model.OrderGroupDO;
import com.pjboy.riddler_reserve.service.GoodsPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsPackageServiceImpl extends ServiceImpl<GoodsPackageMapper, GoodsPackageDO> implements GoodsPackageService {
  @Autowired
  private GoodsPackageMapper goodsPackageMapper;

  @Override
  public List<GoodsPackageDO> getPackageByGoodsId(Integer goodsId) {
    return goodsPackageMapper.getPackageByGoodsId(goodsId);
  }
}
