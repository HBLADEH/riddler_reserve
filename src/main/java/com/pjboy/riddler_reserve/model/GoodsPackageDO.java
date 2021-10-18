package com.pjboy.riddler_reserve.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 *  商品对应套餐表
 */
@Data
@TableName("rm_goods_package")
public class GoodsPackageDO {
  private Integer goodsId; /* 商品ID */
  private String name; /* 套餐名称 */
  private BigDecimal price; /* 套餐价格 */
}
