package com.pjboy.riddler_reserve.exception;

import lombok.Data;

/**
 * 自定义异常
 *
 * @author zyc
 */
@Data
public class RrException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private String message;
  private int code = 500;

  public RrException(String msg) {
    super(msg);
    this.message = msg;
  }

  public RrException(CustomExceptionType customExceptionType, String errorMessage) {
    this.code = customExceptionType.getCode();
    this.message = errorMessage;
  }

  public RrException(String msg, Throwable e) {
    super(msg, e);
    this.message = msg;
  }

  public RrException(String msg, int code) {
    super(msg);
    this.message = msg;
    this.code = code;
  }

  public RrException(String msg, int code, Throwable e) {
    super(msg, e);
    this.message = msg;
    this.code = code;
  }
}