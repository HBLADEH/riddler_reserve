package com.pjboy.riddler_reserve.service;

import com.pjboy.riddler_reserve.model.vo.AfterViewsVO;
import com.pjboy.riddler_reserve.model.vo.DashBoardVO;

import java.util.List;

public interface DashBoardService {
    DashBoardVO getDashBoardData();

    /**
     * 获取上周浏览量
     * @return 浏览量集合
     */
    List<AfterViewsVO> getAfterViews();
}
