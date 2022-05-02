package com.pjboy.riddler_reserve.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("rm_user")
public class UserDO extends BaseModel implements Serializable {

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
}
