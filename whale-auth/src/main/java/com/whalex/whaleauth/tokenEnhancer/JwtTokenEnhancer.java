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
package com.whalex.whaleauth.tokenEnhancer;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import whale.common.security.entity.WhaleUsers;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * jwt返回参数增强
 *
 * @author Chill
 */
public class JwtTokenEnhancer implements TokenEnhancer {
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		WhaleUsers user = (WhaleUsers) authentication.getPrincipal();
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("id",user.getId());
		map.put("account",user.getAccount());
		map.put("phone",user.getPhone());
		map.put("avatar",user.getAvatar());
		map.put("customerName",user.getUsername());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(map);
		return 	accessToken;
	}
}
