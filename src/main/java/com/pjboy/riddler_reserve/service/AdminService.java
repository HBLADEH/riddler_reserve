package com.pjboy.riddler_reserve.service;

import com.pjboy.riddler_reserve.model.AdminDO;
import com.pjboy.riddler_reserve.model.UserDO;
import com.pjboy.riddler_reserve.model.vo.AdminInfoVO;
import com.pjboy.riddler_reserve.model.vo.AdminVO;

public interface AdminService {
  AdminVO checkLogin(String username, String password);

  AdminDO getById(Long id);

  AdminInfoVO getInfoById(Integer id);

  /**
   * 修改用户信息
   * @param adminVO 用户信息
   * @return 是否成功
   */
  boolean changeInfo(AdminVO adminVO);

  /**
   * 确认旧密码是否正确
   * @param loginId 需要检测的管理员 ID
   * @param oldPassword 旧密码
   * @return 是否正确
   */
  boolean checkPassword(Integer loginId, String oldPassword);

  /**
   * 修改管理员密码
   * @param loginId 需要修改的管理员 ID
   * @param newPassword 新密码
   * @return 是否成功
   */
  boolean updatePassword(Integer loginId, String newPassword);
}
