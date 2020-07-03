package com.whalex.whaleauth.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


@Getter
@Setter
public class WhaleXUserDetails extends User {

    private Long id;

    private String account;

    /**
     * 用户名
     */
    private String customerName;

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

    private String username;
    


    public WhaleXUserDetails(String account,String avatar,Long id,String phone,String username,String password, Collection<? extends GrantedAuthority> authorities) {
        super(account, password, authorities);
        this.id = id;
        this.avatar = avatar;
        this.phone = phone;
        this.username = username;
    }


}