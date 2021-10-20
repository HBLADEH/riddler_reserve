package com.pjboy.riddler_reserve.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.GoodsDO;
import com.pjboy.riddler_reserve.model.util.DropDown;
import com.pjboy.riddler_reserve.model.vo.GoodsFromVO;
import com.pjboy.riddler_reserve.model.vo.GoodsVO;
import com.pjboy.riddler_reserve.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class GoodsController {

  @Autowired
  private GoodsService goodsService;

  @GetMapping("/goods/{goodsId}")
  public AjaxResponse selectGoodsById(@PathVariable Integer goodsId) {
    String ErrorSelect = "未找到该商品!";
    GoodsFromVO goodsFromVO = goodsService.selectGoodsById(goodsId);
    if (goodsFromVO != null) return AjaxResponse.success(goodsFromVO);
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorSelect);
  }

  @PostMapping("/goods")
  public AjaxResponse addGoods(@RequestBody GoodsFromVO goodsFromVO) {
    BasicCheck.checkRole("admin");
    String ErrorAdd = "添加商品失败!";
    String ErrorName = "商品名称已存在!";
    if (goodsService.selectGoodsByName(goodsFromVO.getGoods().getName()) != null)
      return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorName);
    //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    //goodsDO.setCreateTime(new Date());
    if (goodsService.addGoods(goodsFromVO) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorAdd);
  }

  @DeleteMapping("/goods/{goodsId}")
  public AjaxResponse deleteGoods(@PathVariable Integer goodsId) {
    BasicCheck.checkRole("admin");
    String ErrorDelete = "删除商品失败!";
    if (goodsService.deleteGoodsById(goodsId) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorDelete);
  }

  @DeleteMapping("/goods")
  public AjaxResponse deleteGoodsByIds(@RequestBody  List<Integer> ids) {
    BasicCheck.checkRole("admin");
    String ErrorDelete = "删除商品失败!";
    if (goodsService.deleteGoodsByIds(ids) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorDelete);
  }

  @PutMapping("/goods")
  public AjaxResponse updateGoodsById(@RequestBody GoodsFromVO goodsFromVO) {
    BasicCheck.checkRole("admin");
    String ErrorUpdate = "修改商品失败!";
    if (goodsService.updateGoods(goodsFromVO) > 0) return AjaxResponse.success();
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorUpdate);
  }

  @GetMapping("/goods/listAll")
  public AjaxResponse selectAllByList(@RequestParam(value = "size") Integer pageSize,
                                      @RequestParam(value = "page") Integer currentPage,
                                      @RequestParam(required = false) String name,
                                      @RequestParam(required = false)
                                      @DateTimeFormat(pattern = "yyyy-MM-dd") Date createTimeStart,
                                      @RequestParam(required = false)
                                      @DateTimeFormat(pattern = "yyyy-MM-dd") Date createTimeEnd) {
    BasicCheck.checkRole("admin");
    String ErrorEmpty = "未查询到商品!";
    Page<GoodsDO> page = new Page<>(currentPage, pageSize);
    IPage<GoodsVO> goodsDOIPage = goodsService.selectGoodsPage(page, name, createTimeStart, createTimeEnd);
    if (goodsDOIPage != null) return AjaxResponse.success(goodsDOIPage);
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
  }

  @GetMapping("/goods/allDW")
  public AjaxResponse getAllDWGoods() {
    BasicCheck.checkRole("admin");
    String ErrorEmpty = "未查询到商品!";
    List<DropDown> goods = goodsService.getAllDWGoods();
    if (goods!=null) return AjaxResponse.success(goods);
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
  }
}

