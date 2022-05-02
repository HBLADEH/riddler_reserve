package com.pjboy.riddler_reserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.pjboy.riddler_reserve.mapper.ViewsMapper;
import com.pjboy.riddler_reserve.model.ViewsDO;
import com.pjboy.riddler_reserve.service.ViewsService;
import com.power.common.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewsServiceImpl implements ViewsService {

    @Autowired
    private ViewsMapper viewsMapper;

    @Override
    public ViewsDO getViewsByDate(String Date) {
        QueryWrapper<ViewsDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("view_date", Date);
        return viewsMapper.selectOne(queryWrapper);
    }

    @Override
    public int updateViewsByDate(Long views, String Date) {
        UpdateWrapper<ViewsDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("view_date", Date);
        ViewsDO viewsDO = new ViewsDO();
        viewsDO.setViews(views);
        return viewsMapper.update(viewsDO, updateWrapper);
    }

    @Override
    public int insertViews(String Date) {
        ViewsDO viewsDO = new ViewsDO();
        viewsDO.setViewDate(DateTimeUtil.strToDate(Date, DateTimeUtil.DATE_FORMAT_DAY));
        return viewsMapper.insert(viewsDO);
    }
}
