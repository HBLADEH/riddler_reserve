package com.pjboy.riddler_reserve.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Data
@TableName("rm_round")
public class RoundDO implements Serializable {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  /**
   * 场次名，唯一
   */
  private String name;
  @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
  private Date startTime;
  @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
  private Date endTime;
}
