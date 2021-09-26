package com.pjboy.riddler_reserve.controller.v1;

import cn.dev33.satoken.stp.StpUtil;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.model.AdminDO;
import com.pjboy.riddler_reserve.model.UserDO;
import com.pjboy.riddler_reserve.model.vo.AdminVO;
import com.pjboy.riddler_reserve.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 管理员控制器
 * @Author: BLADE
 * @Date: 2021/4/5
 */
@RestController
@RequestMapping("/v1")
public class AdminController {

  @Autowired
  private AdminService adminService;

  @PostMapping("/admin/login")
  public AjaxResponse adminLogin(@RequestBody AdminDO adminDO) {
    AdminVO adminVO = adminService.checkLogin(adminDO.getUsername(), adminDO.getPassword());
    if (adminVO != null) {
      StpUtil.setLoginId("admin" + adminVO.getId());
      return AjaxResponse.success(adminVO, "登陆成功!");
    }
    return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, "登陆失败,请检查用户名或者密码!");
  }

  @PostMapping("/admin/doLogout")
  public AjaxResponse logout() {
    StpUtil.logout();
    return AjaxResponse.success();
  }


}
