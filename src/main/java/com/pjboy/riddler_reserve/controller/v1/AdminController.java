package com.pjboy.riddler_reserve.controller.v1;

import cn.dev33.satoken.stp.StpUtil;
import com.pjboy.riddler_reserve.controller.util.BasicCheck;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.AdminDO;
import com.pjboy.riddler_reserve.model.UserDO;
import com.pjboy.riddler_reserve.model.vo.AdminInfoVO;
import com.pjboy.riddler_reserve.model.vo.AdminVO;
import com.pjboy.riddler_reserve.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 管理员控制器
 * @Author: BLADE
 * @Date: 2021/4/5
 */
@RestController
@RequestMapping("/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @GetMapping("/info")
    public AjaxResponse adminInfo() {
        BasicCheck.checkRole("admin");
        String ErrorMessage = "获取管理员信息失败！";
        String loginData = StpUtil.getLoginIdAsString();
        Integer adminId = Integer.valueOf(loginData.substring(5));
        AdminInfoVO adminInfoVO = adminService.getInfoById(adminId);
        if (adminInfoVO != null) return AjaxResponse.success(adminInfoVO);
        return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, ErrorMessage);
    }

    @PostMapping("/login")
    public AjaxResponse adminLogin(@RequestBody AdminDO adminDO) {
        AdminVO adminVO = adminService.checkLogin(adminDO.getUsername(), adminDO.getPassword());
        if (adminVO != null) {
            StpUtil.login("admin" + adminVO.getId());
            /* 返回 Token */
            Map<String, String> map = new HashMap<>();
            map.put("token", StpUtil.getTokenValue());
            return AjaxResponse.success(map, "登陆成功!");
        }
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "登陆失败,请检查用户名或者密码!");
    }

    @PostMapping("/doLogout")
    public AjaxResponse logout() {
        StpUtil.logout();
        return AjaxResponse.success();
    }

    @PostMapping("/changeInfo")
    public AjaxResponse changeInfo(@RequestBody AdminVO adminVO) {
        BasicCheck.checkRole("admin");
        adminVO.setId(BasicCheck.getLoginId());
        adminVO.setUsername(null);
        adminVO.setCreateTime(null);
        adminVO.setUpdateTime(new Date());
        if (adminService.changeInfo(adminVO))
            return AjaxResponse.success();
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "修改管理员信息失败!");
    }


    @PostMapping("/changePassword")
    public AjaxResponse changePassword(@RequestParam String oldPassword, @RequestParam String newPassword) {
        BasicCheck.checkRole("admin");
        String OldPasswordErr = "旧密码输入错误！";
        String PasswordErr = "修改密码出现错误！";
        Integer loginId = BasicCheck.getLoginId();
        if (!adminService.checkPassword(loginId, oldPassword))
            return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, OldPasswordErr);
        if (adminService.updatePassword(loginId, newPassword)) return AjaxResponse.success();
        return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, PasswordErr);
    }

}
