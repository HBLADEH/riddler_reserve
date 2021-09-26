package com.pjboy.riddler_reserve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pjboy.riddler_reserve.model.AdminDO;
import com.pjboy.riddler_reserve.model.vo.AdminVO;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper extends BaseMapper<AdminDO> {
  AdminVO getVOByName(String username);
}
