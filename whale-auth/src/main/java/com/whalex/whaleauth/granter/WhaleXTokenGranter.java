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
package com.whalex.whaleauth.granter;

import com.whalex.userCentre.api.fegin.ISysCustomerFegin;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenGranter;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeTokenGranter;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.implicit.ImplicitTokenGranter;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;
import org.springframework.security.oauth2.provider.refresh.RefreshTokenGranter;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 自定义拓展TokenGranter
 *
 * @author Chill
 */
public class WhaleXTokenGranter implements TokenGranter {

	private DataSource dataSource;

	private AuthenticationManager authenticationManager;

	private UserDetailsService userDetailsService;

	private TokenStore tokenStore;

	private TokenEnhancer jwtTokenEnhancer;

	private JwtAccessTokenConverter jwtAccessTokenConverter;

	private CompositeTokenGranter delegate;

	private ISysCustomerFegin iSysCustomerFegin;

	private ClientDetailsService whaleXClientDetailService;

	public WhaleXTokenGranter(DataSource dataSource, AuthenticationManager authenticationManager, UserDetailsService userDetailsService, TokenStore tokenStore, TokenEnhancer jwtTokenEnhancer, JwtAccessTokenConverter jwtAccessTokenConverter, ISysCustomerFegin iSysCustomerFegin) {
		this.dataSource = dataSource;
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.tokenStore = tokenStore;
		this.jwtTokenEnhancer = jwtTokenEnhancer;
		this.jwtAccessTokenConverter = jwtAccessTokenConverter;
		this.iSysCustomerFegin = iSysCustomerFegin;
	}

	@Override
	public OAuth2AccessToken grant(String grantType, TokenRequest tokenRequest) {
		if (delegate == null) {
			delegate = new CompositeTokenGranter(getDefaultTokenGranters());
		}
		return delegate.grant(grantType, tokenRequest);
	}

	/**
	 * 自定义授权模式
	 */
	private List<TokenGranter> getDefaultTokenGranters() {
		ClientDetailsService clientDetails = whaleXClientDetailService;
		AuthorizationServerTokenServices tokenServices = tokenServices();
		AuthorizationCodeServices authorizationCodeServices = authorizationCodeServices();
		OAuth2RequestFactory requestFactory = requestFactory();

		List<TokenGranter> tokenGranters = new ArrayList<>();
		tokenGranters.add(new AuthorizationCodeTokenGranter(tokenServices, authorizationCodeServices, clientDetails, requestFactory));
		tokenGranters.add(new RefreshTokenGranter(tokenServices, clientDetails, requestFactory));
		ImplicitTokenGranter implicit = new ImplicitTokenGranter(tokenServices, clientDetails, requestFactory);
		tokenGranters.add(implicit);
		tokenGranters.add(new ClientCredentialsTokenGranter(tokenServices, clientDetails, requestFactory));
		if (authenticationManager != null) {
			tokenGranters.add(new ResourceOwnerPasswordTokenGranter(authenticationManager, tokenServices, clientDetails, requestFactory));
		}

		// 自定义第三方认证Granter

		return tokenGranters;
	}


	private AuthorizationCodeServices authorizationCodeServices() {
		return new InMemoryAuthorizationCodeServices();
	}

	private OAuth2RequestFactory requestFactory() {
		return new DefaultOAuth2RequestFactory(whaleXClientDetailService);
	}

	private DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore);
		defaultTokenServices.setSupportRefreshToken(true);
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		List<TokenEnhancer> enhancerList = new ArrayList<>();
		enhancerList.add(jwtTokenEnhancer);
		enhancerList.add(jwtAccessTokenConverter);
		tokenEnhancerChain.setTokenEnhancers(enhancerList);
		defaultTokenServices.setTokenEnhancer(tokenEnhancerChain);
		defaultTokenServices.setClientDetailsService(whaleXClientDetailService);
		addUserDetailsService(defaultTokenServices, userDetailsService);
		return defaultTokenServices;
	}

	private void addUserDetailsService(DefaultTokenServices tokenServices, UserDetailsService userDetailsService) {
		if (userDetailsService != null) {
			PreAuthenticatedAuthenticationProvider provider = new PreAuthenticatedAuthenticationProvider();
			provider.setPreAuthenticatedUserDetailsService(new UserDetailsByNameServiceWrapper<>(userDetailsService));
			tokenServices.setAuthenticationManager(new ProviderManager(Collections.singletonList(provider)));
		}
	}

}
