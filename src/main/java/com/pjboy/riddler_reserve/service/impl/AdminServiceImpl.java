package com.pjboy.riddler_reserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pjboy.riddler_reserve.mapper.AdminMapper;
import com.pjboy.riddler_reserve.mapper.PermissionsMapper;
import com.pjboy.riddler_reserve.model.AdminDO;
import com.pjboy.riddler_reserve.model.PermissionsDO;
import com.pjboy.riddler_reserve.model.UserDO;
import com.pjboy.riddler_reserve.model.vo.AdminInfoVO;
import com.pjboy.riddler_reserve.model.vo.AdminVO;
import com.pjboy.riddler_reserve.model.vo.PermissionsVO;
import com.pjboy.riddler_reserve.service.AdminService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

  @Autowired
  private AdminMapper adminMapper;

  @Autowired
  private PermissionsMapper permissionsMapper;

  @Autowired
  private BCryptPasswordEncoder encoder;

  /**
   * @Description: 登陆检查, 如果登陆成功则返回登陆用户的ID
   * @Param: [username, password]
   * @return: boolean
   * @Author: BLADE
   * @Date: 2021/4/6
   */
  @Override
  public AdminVO checkLogin(String username, String password) {
    QueryWrapper<AdminDO> wrapper = new QueryWrapper<>();
    wrapper.eq("username", username);
    AdminDO adminDO = adminMapper.selectOne(wrapper);
    if (adminDO != null && encoder.matches(password, adminDO.getPassword())) {
      DozerBeanMapper mapper = new DozerBeanMapper();
      return mapper.map(adminDO, AdminVO.class);
    }
    return null;
  }

  @Override
  public AdminDO getById(Long id) {
    return adminMapper.selectById(id);
  }

  @Override
  public AdminInfoVO getInfoById(Integer id) {
    AdminDO adminDO = adminMapper.selectById(id);
    if (adminDO != null) {
      AdminInfoVO adminInfoVO = new AdminInfoVO(adminDO);
      List<PermissionsVO> permissions = permissionsMapper.getPermissionsByAdminId(id);
      if (permissions != null) {
        adminInfoVO.setPermissions(permissions);
        return adminInfoVO;
      }
    }
    return null;
  }
}
