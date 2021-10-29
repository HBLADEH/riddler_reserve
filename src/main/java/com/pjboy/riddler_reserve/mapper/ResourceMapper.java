package com.pjboy.riddler_reserve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pjboy.riddler_reserve.model.ResourceDO;
import com.pjboy.riddler_reserve.model.util.ResourceTargetEnum;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceMapper extends BaseMapper<ResourceDO> {
    int safeDeleteResourceByTarget(@Param("targetType") ResourceTargetEnum targetType, @Param("targetId") Integer targetId);
}
