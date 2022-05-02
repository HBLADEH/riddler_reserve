package com.pjboy.riddler_reserve.model.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.pjboy.riddler_reserve.model.BaseModel;
import com.pjboy.riddler_reserve.model.UserDO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVO extends BaseModel {

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

    public UserVO(UserDO userDO) {
        this.username = userDO.getUsername();
        this.nickname = userDO.getNickname();
        this.avatar = userDO.getAvatar();
        this.email = userDO.getEmail();
    }
}
