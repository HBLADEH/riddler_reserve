package com.pjboy.riddler_reserve.model.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DashBoardVO {
    private Long views; // 今日浏览量
    private Long viewsYesterday; // 昨日日浏览量
    private Long viewsCompareYesterday; // 今日相较昨日浏览量差
    private Integer goodsSum; // 商品数量
    private BigDecimal orderPriceSum; // 订单总额
    private BigDecimal orderPriceSumYesterday; // 昨日订单总额
    private BigDecimal orderPriceSumCompareYesterday; // 今日相较昨日订单总额差
    private Integer orderGroupSum; // 组局数量
    private Integer orderGroupSumYesterday; // 昨日组局数量
    private Integer orderGroupSumCompareYesterday; // 昨日组局数量
    private Long userSum; // 用户总数
}
