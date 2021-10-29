package com.pjboy.riddler_reserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.pjboy.riddler_reserve.mapper.ResourceMapper;
import com.pjboy.riddler_reserve.model.ResourceDO;
import com.pjboy.riddler_reserve.service.ResourceService;
import com.pjboy.riddler_reserve.model.util.ResourceTargetEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;


    @Override
    public boolean insertResource(ResourceDO resource) {
        return resourceMapper.insert(resource) > 0;
    }

    @Override
    public boolean safeDeleteResourceByTarget(ResourceTargetEnum targetType, Integer targetId) {
        return resourceMapper.safeDeleteResourceByTarget(targetType, targetId) > 0;
    }

    @Override
    public boolean saveResourceByUrl(String url) {
        return false;
    }

    @Override
    public List<ResourceDO> selectBadResource() {
        QueryWrapper<ResourceDO> wrapper = new QueryWrapper<>();
        wrapper.isNull("target_id");
        return resourceMapper.selectList(wrapper);
    }

    @Override
    public void clearBadResource() {
        QueryWrapper<ResourceDO> wrapper = new QueryWrapper<>();
        wrapper.isNull("target_id");
        resourceMapper.delete(wrapper);
    }

}
