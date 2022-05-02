package com.pjboy.riddler_reserve.controller.v1;

import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.vo.AfterViewsVO;
import com.pjboy.riddler_reserve.model.vo.DashBoardVO;
import com.pjboy.riddler_reserve.service.DashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/")
public class DashBoardController {
    @Autowired
    private DashBoardService dashBoardService;

    @GetMapping("getDashBoardData")
    public AjaxResponse getDashBoardData() {
        BasicCheck.checkRole("admin");
        DashBoardVO dashBoardVO = dashBoardService.getDashBoardData();
        if (dashBoardVO != null) return AjaxResponse.success(dashBoardVO);
        return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, "获取不到仪表盘信息！");
    }

    @GetMapping("getAfterViews")
    public AjaxResponse getAfterViews() {
        BasicCheck.checkRole("admin");
        List<AfterViewsVO> afterViewsVOList = dashBoardService.getAfterViews();
        if (afterViewsVOList != null) return AjaxResponse.success(afterViewsVOList);
        return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, "获取不到7日浏览量！");
    }
}
