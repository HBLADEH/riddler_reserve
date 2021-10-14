package com.pjboy.riddler_reserve.controller.util;

import cn.dev33.satoken.exception.NotLoginException;
import com.pjboy.riddler_reserve.exception.AjaxResponse;
import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.exception.RrException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * controller 增强器
 */
@Slf4j
@RestControllerAdvice
public class MyControllerAdvice {
  /**
   * 全局异常捕捉处理
   *
   * @param ex
   * @return
   */
  @ExceptionHandler(value = RrException.class)
  public AjaxResponse errorHandler(RrException ex) {
    return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, ex.getMessage());
  }

  /**
   * 处理空指针的异常
   *
   * @param req
   * @param e
   * @return
   */
  @ExceptionHandler(value = NullPointerException.class)
  public AjaxResponse exceptionNullPointerException(HttpServletRequest req, NullPointerException e) {
    String ErrorMessage = "发生空指针异常！原因是:";
    log.error(ErrorMessage, e);
    return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, ErrorMessage + e);
  }

  // 全局异常拦截（拦截项目中的NotLoginException异常）
  @ExceptionHandler(NotLoginException.class)
  public AjaxResponse handlerNotLoginException(NotLoginException nle) {
    // 打印堆栈，以供调试
    nle.printStackTrace();

    // 判断场景值，定制化异常信息
    String message = "";
    if (nle.getType().equals(NotLoginException.NOT_TOKEN)) {
      message = "未提供token";
    } else if (nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
      message = "token无效";
    } else if (nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
      message = "token已过期";
    } else if (nle.getType().equals(NotLoginException.BE_REPLACED)) {
      message = "token已被顶下线";
    } else if (nle.getType().equals(NotLoginException.KICK_OUT)) {
      message = "token已被踢下线";
    } else {
      message = "当前会话未登录";
    }

    // 返回给前端
    return AjaxResponse.error(CustomExceptionType.SYSTEM_ERROR, message);
  }

}