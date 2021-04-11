package com.pjboy.riddler_reserve.service.impl;

import com.pjboy.riddler_reserve.mapper.UserMapper;
import com.pjboy.riddler_reserve.model.UserDO;
import com.pjboy.riddler_reserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public UserDO getById(Long id) {
    return userMapper.selectById(id);
  }
}
