package com.pjboy.riddler_reserve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pjboy.riddler_reserve.model.PermissionsDO;
import com.pjboy.riddler_reserve.model.vo.PermissionsVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionsMapper extends BaseMapper<PermissionsDO> {
  List<PermissionsVO> getPermissionsByAdminId(Integer adminId);
}
