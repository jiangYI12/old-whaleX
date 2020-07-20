package com.whalex.common.core.util;

import cn.hutool.json.JSONObject;
import com.whalex.common.core.baseEntity.WhaleUsers;
import com.whalex.common.tool.webUtil.WebUtils;
import io.jsonwebtoken.Claims;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: 解析JWT 获取用户相关信息
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/19 21:20
 */
public class AuthUtil {

    public static String JWT_PARSE_KEY = "JWT_PARSE_KEY";



    public static WhaleUsers getWhaleXUser(){
        HttpServletRequest httpServletRequest = WebUtils.getRequest();
        String claims = httpServletRequest.getParameter(JWT_PARSE_KEY);

        return null;
    }

    public static Long getUserId(){
        HttpServletRequest httpServletRequest = WebUtils.getRequest();
        String claims = httpServletRequest.getParameter(JWT_PARSE_KEY);

        return null;
    }

}
