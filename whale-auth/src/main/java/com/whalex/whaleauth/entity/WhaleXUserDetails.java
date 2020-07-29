package com.whalex.whaleauth.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;


@Getter
@Setter
public class WhaleXUserDetails extends User {

    private Long id;

    private String account;

    private String tenantCode;
    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    private String username;

    private List<String> roles;

    private List<String> roleIds;

    public WhaleXUserDetails(String account,String avatar,Long id,String phone,String username,String tenantCode
            ,String password,List<String> roles,List<String> roleIds, Collection<? extends GrantedAuthority> authorities) {
        super(account, password, authorities);
        this.id = id;
        this.tenantCode = tenantCode;
        this.avatar = avatar;
        this.phone = phone;
        this.account = account;
        this.username = username;
        this.roles = roles;
        this.roleIds = roleIds;
    }


}