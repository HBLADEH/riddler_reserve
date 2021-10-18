package com.pjboy.riddler_reserve.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
   * 套餐, 使用 json 来存储 {name: ‘名称’, price: ‘价格’}
   */
  //private String packageList;
  /**
   * 游玩人数
   */
  private Integer playNum;
}
