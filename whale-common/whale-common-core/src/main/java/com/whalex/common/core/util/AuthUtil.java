package com.whalex.common.core.util;

import com.whalex.common.core.baseEntity.WhaleUsers;
import com.whalex.common.core.constant.SecurityConstants;
import com.whalex.common.tool.webUtil.WebUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: 解析JWT 获取用户相关信息
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/19 21:20
 */
public class AuthUtil {

    public static WhaleUsers getWhaleXUser(){
        HttpServletRequest httpServletRequest = WebUtils.getRequest();
        String token = httpServletRequest.getHeader(SecurityConstants.AUTHORIZATION).replace(SecurityConstants.TOKEN_PREFIX,"").trim();
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.SIGN_KEY)
                .parseClaimsJws(token).getBody();
        return (WhaleUsers) claims;
    }

    public static Long getId(){
        HttpServletRequest httpServletRequest = WebUtils.getRequest();
        String token = httpServletRequest.getHeader(SecurityConstants.AUTHORIZATION).replace(SecurityConstants.TOKEN_PREFIX,"").trim();
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.SIGN_KEY)
                .parseClaimsJws(token).getBody();
        WhaleUsers whaleUsers =  (WhaleUsers) claims;
        return whaleUsers.getId();
    }


    public static String getTenant(){
        HttpServletRequest httpServletRequest = WebUtils.getRequest();
        String token = httpServletRequest.getHeader(SecurityConstants.AUTHORIZATION).replace(SecurityConstants.TOKEN_PREFIX,"").trim();
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.SIGN_KEY)
                .parseClaimsJws(token).getBody();
        WhaleUsers whaleUsers =  (WhaleUsers) claims;
        return whaleUsers.getTenantCode();
    }

}
