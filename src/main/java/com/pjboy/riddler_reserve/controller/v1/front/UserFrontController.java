package com.pjboy.riddler_reserve.controller.v1.front;

import cn.dev33.satoken.stp.StpUtil;
import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.UserDO;
import com.pjboy.riddler_reserve.model.vo.UserVO;
import com.pjboy.riddler_reserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.rmi.StubNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 用户控制器
 * @Author: BLADE
 * @Date: 2021/4/5
 */
@RestController
@RequestMapping("/v1/front")
public class UserFrontController {

    @Autowired
    private UserService userService;

    /**
     * 前台登陆
     *
     * @param username 用户名
     * @param password 密码
     * @return 是否登陆成功
     */
    @PostMapping("/login")
    public AjaxResponse login(@RequestParam String username, @RequestParam String password) {
        UserDO userDO = userService.checkLogin(username, password);
        if (userDO != null) {
            StpUtil.login("users" + userDO.getId());
            /* 返回 Token */
            Map<String, String> map = new HashMap<>();
            map.put("token", StpUtil.getTokenValue());
            map.put("username", userDO.getUsername());
            map.put("nickname", userDO.getNickname());
            return AjaxResponse.success(map, "登陆成功!");
        }
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "登陆失败,请检查用户名或者密码!");
    }

    @PostMapping("/doLogout")
    public AjaxResponse logout() {
        StpUtil.logout();
        return AjaxResponse.success();
    }

    @PostMapping("/changePassword")
    public AjaxResponse changePassword(@RequestParam String oldPassword, @RequestParam String newPassword) {
        BasicCheck.checkRole("users");
        String OldPasswordErr = "旧密码输入错误！";
        String PasswordErr = "修改密码出现错误！";
        Integer loginId = BasicCheck.getLoginId();
        if (!userService.checkPassword(loginId, oldPassword))
            return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, OldPasswordErr);
        if (userService.updatePassword(loginId, newPassword)) return AjaxResponse.success();
        return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, PasswordErr);
    }

    @PostMapping("/register")
    public AjaxResponse register(@RequestBody UserDO userDO) {
        String UsernameErr = "用户名已存在!";
        String NicknameErr = "昵称已存在!";
        String Err = "出现异常！";
        if (!userService.checkUsername(userDO.getUsername()))
            return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, UsernameErr);
        if (!userService.checkNickname(userDO.getNickname()))
            return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, NicknameErr);
        if (userService.doRegister(userDO))
            return AjaxResponse.success();
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, Err);
    }


    @GetMapping("/userInfo")
    public AjaxResponse getUserInfo() {
        BasicCheck.checkRole("users");
        UserVO userVO = userService.getUserInfo(BasicCheck.getLoginId());
        if (userVO != null) return AjaxResponse.success(userVO);
        return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, "获取用户信息失败!");
    }
}
