package com.pjboy.riddler_reserve.model.vo;

import com.pjboy.riddler_reserve.model.BaseModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsVO extends BaseModel implements Serializable {
  /**
   * 商品名称，唯一
   */
  private String name;

  /**
   * 游玩人数
   */
  private Integer playNum;
}
