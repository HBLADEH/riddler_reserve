package com.pjboy.riddler_reserve.model.vo;

import com.pjboy.riddler_reserve.model.AdminDO;
import com.pjboy.riddler_reserve.model.PermissionsDO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AdminInfoVO {
  /**
   * 用户名，唯一
   */
  private String username;

  /**
   * 用户昵称
   */
  private String nickname;

  /**
   * 头像url
   */
  private String avatar;

  /**
   * 邮箱
   */
  private String email;

  /**
   * 权限集合
   */
  private List<PermissionsVO> permissions;

  public AdminInfoVO(AdminDO adminDO) {
    this.username = adminDO.getUsername();
    this.nickname = adminDO.getNickname();
    this.avatar = adminDO.getAvatar();
    this.email = adminDO.getEmail();
  }
}
