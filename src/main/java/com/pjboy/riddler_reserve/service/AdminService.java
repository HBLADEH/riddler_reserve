package com.pjboy.riddler_reserve.service;

import com.pjboy.riddler_reserve.model.AdminDO;
import com.pjboy.riddler_reserve.model.UserDO;
import com.pjboy.riddler_reserve.model.vo.AdminVO;

public interface AdminService {
  AdminVO checkLogin(String username, String password);

  AdminDO getById(Long id);
}
