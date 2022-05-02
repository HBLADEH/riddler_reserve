package com.pjboy.riddler_reserve.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjboy.riddler_reserve.model.UserDO;
import com.pjboy.riddler_reserve.model.vo.UserVO;

import java.util.List;

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

    /**
     * 检验用户名是否重复
     *
     * @param username 用户名
     * @return 是否重复
     */
    boolean checkUsername(String username);

    /**
     * 检验昵称是否重复
     *
     * @param nickname 昵称
     * @return 是否重复
     */
    boolean checkNickname(String nickname);

    /**
     * 添加用户
     *
     * @param userDO 用户信息
     * @return 是否成功
     */
    boolean doRegister(UserDO userDO);

    /**
     * 获取 用户信息
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    UserVO getUserInfo(Integer userId);


    /**
     * 分页查询用户
     *
     * @param page     分页
     * @param username 用户名
     * @param nickname 昵称
     * @return 用户分页列表
     */
    IPage<UserVO> selectUserPage(Page<?> page, String username, String nickname);

    int deleteUserByIds(List<Integer> ids);
}
