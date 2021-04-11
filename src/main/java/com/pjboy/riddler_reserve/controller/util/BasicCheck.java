package com.pjboy.riddler_reserve.controller.util;

import cn.dev33.satoken.stp.StpUtil;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.exception.RrException;

public class BasicCheck {

  public static void checkLogin() {
    String errorLogin = "未检测到用户登陆，请先登陆!";
    if (!StpUtil.isLogin()) throw new RrException(errorLogin);
  }

  public static void checkRole(String role) {
    checkLogin();
    String errorAuthority = "权限不足!";
    if (!StpUtil.hasRole(role)) throw new RrException(errorAuthority);
  }
}
