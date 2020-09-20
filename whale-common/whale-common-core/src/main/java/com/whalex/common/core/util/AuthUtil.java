package com.whalex.common.core.util;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.whalex.common.core.baseEntity.WhaleUsers;
import com.whalex.common.tool.webUtil.WebUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Description: 解析JWT 获取用户相关信息
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/19 21:20
 */
public class AuthUtil {

    public static String JWT_PARSE_KEY = "WHALEX_JWT_PARSE_KEY";


    public static WhaleUsers getWhaleXUser(){
        HttpServletRequest httpServletRequest = WebUtils.getRequest();
        if(ObjectUtil.isEmpty(httpServletRequest)) return null;
        String claims = httpServletRequest.getHeader(JWT_PARSE_KEY);
        if(ObjectUtil.isEmpty(claims)){
            return null;
        }
        Claims claimStr = JSONUtil.toBean(claims,Claims.class);
        WhaleUsers whaleUsers = new WhaleUsers();
        BeanUtils.copyProperties(claimStr,whaleUsers);
        return whaleUsers;
    }

    public static Long getUserId(){
        HttpServletRequest httpServletRequest = WebUtils.getRequest();
        if(ObjectUtil.isEmpty(httpServletRequest)) return null;
        String claims = httpServletRequest.getHeader(JWT_PARSE_KEY);
        if(ObjectUtil.isEmpty(claims)){
            return null;
        }
        Map<String,Object> claimStr = JSONUtil.toBean(claims,Map.class);
        return Long.valueOf(claimStr.get("id").toString());
    }

    public static String getTenantCode(){
        HttpServletRequest httpServletRequest = WebUtils.getRequest();
        if(ObjectUtil.isEmpty(httpServletRequest)) return null;
        String claims = httpServletRequest.getHeader(JWT_PARSE_KEY);
        if(ObjectUtil.isEmpty(claims)){
            return null;
        }
        Map<String,Object> claimStr = JSONUtil.toBean(claims,Map.class);
        return claimStr.get("tenantCode").toString();
    }
}
