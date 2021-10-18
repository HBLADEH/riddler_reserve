package com.pjboy.riddler_reserve.model.vo;

import com.pjboy.riddler_reserve.model.GoodsDO;
import com.pjboy.riddler_reserve.model.GoodsPackageDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsFromVO {
  private GoodsDO goods;
  private List<GoodsPackageDO> packageList;
}
