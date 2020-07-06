package com.whalex.whaleauth.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * @description: 客户端校验
 * @author: 🐋鲸鱼
 * @date: 2020/7/6
 */
public class WhaleXClientDetailService extends JdbcClientDetailsService {

    public WhaleXClientDetailService(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    @Cacheable(value = "ouath", key = "#clientId", unless = "#result == null")
    public ClientDetails loadClientByClientId(String clientId) throws InvalidClientException {
        return super.loadClientByClientId(clientId);
    }
}
