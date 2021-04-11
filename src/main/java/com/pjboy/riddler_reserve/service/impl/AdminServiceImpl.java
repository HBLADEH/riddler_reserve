package com.pjboy.riddler_reserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pjboy.riddler_reserve.mapper.AdminMapper;
import com.pjboy.riddler_reserve.model.AdminDO;
import com.pjboy.riddler_reserve.model.UserDO;
import com.pjboy.riddler_reserve.service.AdminService;
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
  BCryptPasswordEncoder encoder;

  /**
   * @Description: 登陆检查, 如果登陆成功则返回登陆用户的ID
   * @Param: [username, password]
   * @return: boolean
   * @Author: BLADE
   * @Date: 2021/4/6
   */
  @Override
  public AdminDO checkLogin(String username, String password) {
    QueryWrapper<AdminDO> wrapper = new QueryWrapper<>();
    wrapper.eq("username", username);
    AdminDO adminDO = adminMapper.selectOne(wrapper);
    return adminDO != null && encoder.matches(password, adminDO.getPassword()) ? adminDO : null;
  }

  @Override
  public AdminDO getById(Long id) {
    return adminMapper.selectById(id);
  }
}
