package com.pjboy.riddler_reserve.service;

import com.pjboy.riddler_reserve.model.ResourceDO;
import com.pjboy.riddler_reserve.model.util.ResourceTargetEnum;

import java.util.List;

public interface ResourceService {
    boolean insertResource(ResourceDO resource);
    boolean safeDeleteResourceByTarget(Integer targetType, Integer targetId);
    boolean safeDeleteResourceByTargets(Integer targetType, List<Integer> targetIds);
    boolean saveResourceByUrl(String url,Integer targetType,Integer targetId);
    List<ResourceDO> selectBadResource();
    void clearBadResource();
}
