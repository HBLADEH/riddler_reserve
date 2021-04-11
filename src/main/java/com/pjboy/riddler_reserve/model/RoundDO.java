package com.pjboy.riddler_reserve.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("rm_round")
public class RoundDO implements Serializable {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  /**
   * 场次名，唯一
   */
  private String name;
}
