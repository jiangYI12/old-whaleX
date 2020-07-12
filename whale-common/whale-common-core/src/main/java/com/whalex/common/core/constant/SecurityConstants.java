package com.whalex.common.core.constant;

/**
 * Description: 认证常量
 *
 * @author: 🐋鲸鱼
 * date: 2020/7/12 10:33
 */
public interface SecurityConstants {
    /**
     * 加盐值
     */
    String SIGN_KEY = "whaleX";

    /**
     * 无需token必传值key
     */
    String INNER = "inner";

    /**
     * 无需token必传值value
     */
    String INNER_VALUE = "whaleX_inner";


    /**
     * sys_oauth_client_details 表的字段，不包括client_id、client_secret
     */
    String CLIENT_FIELDS = "client_id, client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";


    /**
     * JdbcClientDetailsService 查询语句
     */
    String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS + " from sys_oauth_client_details";


    /**
     * 按条件client_id 查询
     */
    String DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?  and tenant_code = %s";
}
