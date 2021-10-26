package com.pjboy.riddler_reserve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pjboy.riddler_reserve.model.GoodsPackageDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsPackageMapper extends BaseMapper<GoodsPackageDO> {
  List<GoodsPackageDO> getPackageByGoodsId(@Param("goodsId") Integer goodsId);
}
