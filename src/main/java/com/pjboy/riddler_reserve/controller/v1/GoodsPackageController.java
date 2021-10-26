package com.pjboy.riddler_reserve.controller.v1;

import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.GoodsPackageDO;
import com.pjboy.riddler_reserve.service.GoodsPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class GoodsPackageController {
  @Autowired
  private GoodsPackageService goodsPackageService;

  @GetMapping("/goodsPackages/getByGoods/{goodsId}")
  private AjaxResponse getGoodsPackagesByGoodsId(@PathVariable Integer goodsId) {
    BasicCheck.checkRole("admin");
    String ErrorSelect = "未找到套餐!";
    List<GoodsPackageDO> goodsPackageList = goodsPackageService.getPackageByGoodsId(goodsId);
    if (goodsPackageList != null) return AjaxResponse.success(goodsPackageList);
    return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, ErrorSelect);
  }

}
