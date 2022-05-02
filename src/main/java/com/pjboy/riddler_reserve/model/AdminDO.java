package com.pjboy.riddler_reserve.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.pjboy.riddler_reserve.model.vo.AdminVO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@TableName("rm_admin")
@NoArgsConstructor
public class AdminDO extends BaseModel implements Serializable {

  /**
   * 用户名，唯一
   */
  private String username;

  /**
   * 用户昵称
   */
  private String nickname;

  /**
   * 用户密码
   */
  private String password;


  /**
   * 头像url
   */
  private String avatar;

  /**
   * 邮箱
   */
  private String email;

  public AdminDO(AdminVO adminVO) {
    this.setId(adminVO.getId());
    this.username = adminVO.getUsername();
    this.nickname = adminVO.getNickname();

    this.avatar = adminVO.getAvatar();
    this.email = adminVO.getEmail();
  }
}
