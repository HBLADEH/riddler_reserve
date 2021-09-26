package com.pjboy.riddler_reserve.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("rm_order")
public class OrderDO extends BaseModel implements Serializable {
  private String orderId;
  private Integer orderGoods;
  private Integer orderRound;
  private Integer orderRoom;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date orderTime;
  private BigDecimal orderPrice;
  private Integer orderState;
  private Integer userId;
}
