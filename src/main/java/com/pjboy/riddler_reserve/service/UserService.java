package com.pjboy.riddler_reserve.service;

import com.pjboy.riddler_reserve.model.UserDO;

public interface UserService {
  UserDO getById(Long id);
  UserDO checkLogin(String username, String password);
}
