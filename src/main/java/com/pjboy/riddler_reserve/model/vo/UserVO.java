package com.pjboy.riddler_reserve.model.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("rm_user")

public class UserVO {
  /**
   * 用户名，唯一
   */
  private String username;

  /**
   * 用户昵称
   */
  private String nickname;

  /**
   * 用户密码 隐藏
   */
  //private String password;

  /**
   * 头像url
   */
  private String avatar;

  /**
   * 邮箱
   */
  private String email;
}
