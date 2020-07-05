package com.whalex.userCentre.api.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * sys_oauth_client_details
 * @author 
 */
@Data
public class SysOauthClientDetails implements Serializable {
    /**
     * ID
     */
    private Integer id;

    private String clientId;

    private String resourceIds;

    private String clientSecret;

    private String scope;

    private String authorizedGrantTypes;

    private String webServerRedirectUri;

    private String authorities;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionalInformation;

    private String autoapprove;

    /**
     * 所属租户
     */
    private Integer tenantCode;

    /**
     * 0未删除 删除
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;
}