package com.pjboy.riddler_reserve.service.impl;

import com.pjboy.riddler_reserve.mapper.DashBoardMapper;
import com.pjboy.riddler_reserve.model.vo.AfterViewsVO;
import com.pjboy.riddler_reserve.model.vo.DashBoardVO;
import com.pjboy.riddler_reserve.service.DashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashBoardServiceImpl implements DashBoardService {

    @Autowired
    private DashBoardMapper dashBoardMapper;

    @Override
    public DashBoardVO getDashBoardData() {
        return dashBoardMapper.getDashBoardData();
    }

    @Override
    public List<AfterViewsVO> getAfterViews() {
        return dashBoardMapper.getAfterViews();
    }
}
