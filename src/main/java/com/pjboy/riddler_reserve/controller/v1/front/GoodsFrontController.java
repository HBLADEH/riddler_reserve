package com.pjboy.riddler_reserve.controller.v1.front;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.GoodsDO;
import com.pjboy.riddler_reserve.model.vo.GoodsFromVO;
import com.pjboy.riddler_reserve.model.vo.GoodsVO;
import com.pjboy.riddler_reserve.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/front/goods")
public class GoodsFrontController {

    @Autowired
    private GoodsService goodsService;


    @GetMapping("/listAll")
    public AjaxResponse listAllGoods(@RequestParam(value = "size") Integer pageSize,
                                     @RequestParam(value = "page") Integer currentPage,
                                     @RequestParam(required = false) String name) {
        String ErrorEmpty = "未查询到商品!";
        Page<GoodsDO> page = new Page<>(currentPage, pageSize);
        IPage<GoodsVO> goodsDOIPage = goodsService.selectGoodsPage(page, name, null, null);
        if (goodsDOIPage != null) return AjaxResponse.success(goodsDOIPage);
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorEmpty);
    }

    @GetMapping("/{goodsId}")
    public AjaxResponse selectGoodsById(@PathVariable Integer goodsId) {
        String ErrorSelect = "未找到该商品!";
        GoodsFromVO goodsFromVO = goodsService.selectGoodsById(goodsId);
        if (goodsFromVO != null) return AjaxResponse.success(goodsFromVO);
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, ErrorSelect);
    }

    @GetMapping("/goodsDW")
    public AjaxResponse getGoodsDW(@RequestParam(required = false) String goodsName) {
        return AjaxResponse.success(goodsService.getGoodsDW(goodsName));
    }
}
