package com.pjboy.riddler_reserve.controller.v1;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.GoodsDO;
import com.pjboy.riddler_reserve.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/v1")
public class GoodsController {

  @Autowired
  private GoodsService goodsService;

  @GetMapping("/goods/{goodsId}")
  public AjaxResponse selectGoodsById(@PathVariable Integer goodsId) {
    String ErrorSelect = "未找到该商品!";
    GoodsDO goodsDO = goodsService.selectGoodsById(goodsId);
    if (goodsDO != null) return AjaxResponse.success(goodsDO);
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorSelect);
  }

  @PostMapping("/goods")
  public AjaxResponse addGoods(@RequestBody GoodsDO goodsDO) {
    BasicCheck.checkRole("admin");
    String ErrorAdd = "添加商品失败!";
    String ErrorName = "商品名称已存在!";
    if (goodsService.selectGoodsByName(goodsDO.getName()) != null)
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorName);
    //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    //goodsDO.setCreateTime(new Date());
    if (goodsService.addGoods(goodsDO) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorAdd);
  }

  @DeleteMapping("/goods/{goodsId}")
  public AjaxResponse deleteGoods(@PathVariable Integer goodsId) {
    BasicCheck.checkRole("admin");
    String ErrorDelete = "删除商品失败!";
    if (goodsService.deleteGoodsById(goodsId) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorDelete);
  }

  @PutMapping("/goods")
  public AjaxResponse updateGoodsById(@RequestBody GoodsDO goodsDO) {
    BasicCheck.checkRole("admin");
    String ErrorUpdate = "修改商品失败!";
    if (goodsService.updateGoods(goodsDO) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorUpdate);
  }

  @GetMapping("/goods/listAll")
  public AjaxResponse selectAllByList(@RequestParam() Integer pageSize,
                                      @RequestParam() Integer currentPage,
                                      @RequestParam(required = false) String name,
                                      @RequestParam(required = false)
                                      @DateTimeFormat(pattern = "yyyy-MM-dd") Date createTimeStart,
                                      @RequestParam(required = false)
                                      @DateTimeFormat(pattern = "yyyy-MM-dd") Date createTimeEnd) {
    //BasicCheck.checkRole("admin");
    String ErrorEmpty = "未查询到商品!";
    Page<GoodsDO> page = new Page<>(currentPage, pageSize);
    IPage<GoodsDO> goodsDOIPage = goodsService.selectGoodsPage(page, name, createTimeStart, createTimeEnd);
    if (goodsDOIPage != null) return AjaxResponse.success(goodsDOIPage);
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
  }

}

