package com.whalex.whaleauth.customException;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * Description: 自定义认证异常类
 *
 * @author: 🐋鲸鱼
 * date: 2020/8/7 22:39
 */
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOauthException extends OAuth2Exception {

    private Integer code;

    public CustomOauthException(String msg, Throwable t) {
        super(msg);
        if(t instanceof CustomOauthException){
            this.code =((CustomOauthException)t).getCode();
        }else {
            this.code = ((OAuth2Exception)t).getHttpErrorCode();
        }
    }

    public CustomOauthException(String msg,Integer code) {
        super(msg);
        this.code = code;
    }

    public Integer getCode(){
        return code;
    }

}
