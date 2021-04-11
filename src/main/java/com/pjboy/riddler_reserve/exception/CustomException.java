package com.pjboy.riddler_reserve.exception;

/**
 * @program: ssy_back
 * @description: 自定义异常处理
 * @author: BLADE
 * @create: 2020-10-24 23:57
 **/
public class CustomException extends RuntimeException {

  // 异常错误代码
  private int code;

  // 异常信息
  private String message;

  public CustomException() {
  }

  public CustomException(CustomExceptionType exceptionTypeEnum) {
    this.code = exceptionTypeEnum.getCode();
    this.message = exceptionTypeEnum.getDesc();
  }

  public CustomException(CustomExceptionType exceptionTypeEnum, String message) {
    this.code = exceptionTypeEnum.getCode();
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
