package com.pjboy.riddler_reserve.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("rm_order_group")
public class OrderGroupDO {
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;
  private Integer goodsId;
  private Integer roomId;
  private Integer roundId;
  private String packageName;
  private BigDecimal packagePrice;
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date playTime;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
}
