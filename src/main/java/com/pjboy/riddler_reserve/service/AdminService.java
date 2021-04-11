package com.pjboy.riddler_reserve.service;

import com.pjboy.riddler_reserve.model.AdminDO;
import com.pjboy.riddler_reserve.model.UserDO;

public interface AdminService {
  AdminDO checkLogin(String username, String password);

  AdminDO getById(Long id);
}
