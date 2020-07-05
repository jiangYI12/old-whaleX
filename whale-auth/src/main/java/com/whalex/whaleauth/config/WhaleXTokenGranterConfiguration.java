/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package com.whalex.whaleauth.config;

import com.whalex.userCentre.api.fegin.ISysCustomerFegin;
import com.whalex.whaleauth.tokenEnhancer.JwtTokenEnhancer;
import com.whalex.whaleauth.granter.WhaleXTokenGranter;
import com.whalex.whaleauth.service.CustomerDetailService;
import com.whalex.whaleauth.service.WhaleXClientDetailService;
import lombok.AllArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;

/**
 * 自定义TokenGranter配置类
 *
 * @author Chill
 */
@Configuration
@AllArgsConstructor
public class WhaleXTokenGranterConfiguration {

	private DataSource dataSource;

	private CustomerDetailService customerDetailService;

	private AuthenticationManager authenticationManager;

	private JwtAccessTokenConverter jwtAccessTokenConverter;

	private JwtTokenEnhancer jwtTokenEnhancer;

	private TokenStore tokenStore;

	private ISysCustomerFegin iSysCustomerFegin;

	@Bean
	public WhaleXTokenGranter bladeTokenGranter() {
		return new WhaleXTokenGranter(dataSource,authenticationManager,customerDetailService,
				tokenStore,jwtTokenEnhancer,jwtAccessTokenConverter,iSysCustomerFegin);
	}

}
