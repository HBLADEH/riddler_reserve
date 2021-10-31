package com.pjboy.riddler_reserve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pjboy.riddler_reserve.model.ResourceDO;
import com.pjboy.riddler_reserve.model.util.ResourceTargetEnum;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceMapper extends BaseMapper<ResourceDO> {
    int safeDeleteResourceByTarget(@Param("targetType") Integer targetType, @Param("targetId") Integer targetId);
    int safeDeleteResourceByTargets(@Param("targetType") Integer targetType, @Param("targetIds") List<Integer> targetIds);

    int saveResourceByUrl(@Param("url") String url, @Param("targetType") Integer targetType, @Param("targetId") Integer targetId);
}
