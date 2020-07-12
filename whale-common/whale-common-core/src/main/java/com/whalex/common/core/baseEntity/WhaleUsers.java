package com.whalex.common.core.baseEntity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/1 21:28
 */
@Getter
@Setter
public class WhaleUsers implements Serializable {

    private Long id;

    private String account;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    private List<String> roles;

    private List<String> permissions;

    private static final long serialVersionUID = 1L;


}
