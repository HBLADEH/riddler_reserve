package com.pjboy.riddler_reserve.service;

import com.pjboy.riddler_reserve.model.UserDO;

public interface UserService {
    UserDO getById(Long id);

    UserDO checkLogin(String username, String password);

    /**
     * 检查密码
     *
     * @param id       要检查的用户 ID
     * @param password 要检查的密码
     * @return 是否通过
     */
    boolean checkPassword(Integer id, String password);

    /**
     * 修改密码
     *
     * @param id          要修改密码的用户 ID
     * @param newPassword 新密码
     * @return 修改是否成功
     */
    boolean updatePassword(Integer id, String newPassword);
}
