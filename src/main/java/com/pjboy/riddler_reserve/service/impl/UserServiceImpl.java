package com.pjboy.riddler_reserve.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pjboy.riddler_reserve.mapper.UserMapper;
import com.pjboy.riddler_reserve.model.AdminDO;
import com.pjboy.riddler_reserve.model.UserDO;
import com.pjboy.riddler_reserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private BCryptPasswordEncoder encoder;


  @Override
  public UserDO getById(Long id) {
    return userMapper.selectById(id);
  }


  @Override
  public UserDO checkLogin(String username, String password) {
    QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("username", username);
    UserDO userDO = userMapper.selectOne(queryWrapper);
    return userDO != null && encoder.matches(password, userDO.getPassword()) ? userDO : null;
  }
}
