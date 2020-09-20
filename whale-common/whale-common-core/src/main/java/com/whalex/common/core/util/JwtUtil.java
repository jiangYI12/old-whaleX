package com.whalex.common.core.util;

import com.whalex.common.core.constant.SecurityConstants;
import com.whalex.common.tool.webUtil.WebUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Description: jwt工具类
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/20 19:43
 */
public class JwtUtil {
    public static String BASE64_SECURITY;

    static {
        BASE64_SECURITY = Base64.getEncoder().encodeToString(SecurityConstants.SIGN_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public static Claims parseJWT(){
        HttpServletRequest httpServletRequest = WebUtils.getRequest();
        String token = httpServletRequest.getHeader(SecurityConstants.AUTHORIZATION).replace(SecurityConstants.TOKEN_PREFIX,"").trim();
        Claims claims = Jwts.parser()
                .setSigningKey(Base64.getDecoder().decode(BASE64_SECURITY))
                .parseClaimsJws(token).getBody();
        return  claims;
    }

    public static Claims parseJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(Base64.getDecoder().decode(BASE64_SECURITY))
                .parseClaimsJws(token)
                .getBody();
        return  claims;
    }
}
