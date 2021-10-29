package com.pjboy.riddler_reserve.service;

import com.pjboy.riddler_reserve.model.ResourceDO;
import com.pjboy.riddler_reserve.model.util.ResourceTargetEnum;

import java.util.List;

public interface ResourceService {
    boolean insertResource(ResourceDO resource);
    boolean safeDeleteResourceByTarget(ResourceTargetEnum targetType, Integer targetId);
    boolean saveResourceByUrl(String url);
    List<ResourceDO> selectBadResource();
    void clearBadResource();
}
