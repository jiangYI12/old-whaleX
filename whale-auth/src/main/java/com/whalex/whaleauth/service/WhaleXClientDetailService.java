package com.whalex.whaleauth.service;

import com.whalex.common.core.constant.SecurityConstants;
import com.whalex.common.core.constant.SysConstant;
import com.whalex.common.tool.webUtil.WebUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * @description: 客户端校验
 * @author: 🐋鲸鱼
 * @date: 2020/7/6
 */
@Service
public class WhaleXClientDetailService extends JdbcClientDetailsService {


    public WhaleXClientDetailService(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    @Cacheable(value = "ouath", key = "#clientId", unless = "#result == null")
    public ClientDetails loadClientByClientId(String clientId) throws InvalidClientException {
        super.setSelectClientDetailsSql(
                String.format(SecurityConstants.DEFAULT_SELECT_STATEMENT, WebUtils.getRequest().getHeader(SysConstant.TENANT_CODE)));
        return super.loadClientByClientId(clientId);
    }


}
