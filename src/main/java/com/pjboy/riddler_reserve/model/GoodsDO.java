package com.pjboy.riddler_reserve.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("rm_goods")
public class GoodsDO extends BaseModel implements Serializable {

  /**
   * 商品名称，唯一
   */
  private String name;

  /**
   * 描述
   */
  private String description;

  /**
   * 游玩人数
   */
  private Integer playNum;

  private String coverImg; // 封面
}
