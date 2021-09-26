package com.pjboy.riddler_reserve.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.pjboy.riddler_reserve.model.BaseModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("rm_order")
public class OrderVO implements Serializable {
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;
  private String orderId;
  private String goods;
  private String round;
  private String room;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date orderTime;
  private Integer orderState;
  private Integer userId;
}
