package com.pjboy.riddler_reserve.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderGroupVO {
  private Integer id;
  private String GoodsName;
  private Integer playNum;
  private String roomName;
  private String roundName;
  private String packageName;
  private BigDecimal packagePrice;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
}
