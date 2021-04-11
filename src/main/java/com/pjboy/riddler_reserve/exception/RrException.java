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

  private String msg;
  private int code = 500;

  public RrException(String msg) {
    super(msg);
    this.msg = msg;
  }

  public RrException(String msg, Throwable e) {
    super(msg, e);
    this.msg = msg;
  }

  public RrException(String msg, int code) {
    super(msg);
    this.msg = msg;
    this.code = code;
  }

  public RrException(String msg, int code, Throwable e) {
    super(msg, e);
    this.msg = msg;
    this.code = code;
  }
}