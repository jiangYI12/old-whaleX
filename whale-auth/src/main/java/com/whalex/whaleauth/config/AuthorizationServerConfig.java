package com.whalex.whaleauth.config;

import com.whalex.whaleauth.tokenEnhancer.JwtTokenEnhancer;
import com.whalex.whaleauth.granter.WhaleXTokenGranter;
import com.whalex.whaleauth.service.WhaleXCustomerDetailService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@AllArgsConstructor
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private DataSource dataSource;

    private WhaleXCustomerDetailService whaleXCustomerDetailService;

    private AuthenticationManager authenticationManager;

    private JwtAccessTokenConverter jwtAccessTokenConverter;

    private JwtTokenEnhancer jwtTokenEnhancer;

    private TokenStore tokenStore;

    private WhaleXTokenGranter whaleXTokenGranter;

    private ClientDetailsService whaleXClientDetailService;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //不配置這段無法使用check_token
        security
                .tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()")
                //让/oauth/token支持client_id以及client_secret作登录认证
                .allowFormAuthenticationForClients();
    }



    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //查找该资源服务
        clients.withClientDetails(whaleXClientDetailService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                .tokenStore(tokenStore)
                // 必须指定，否则refresh_token会报错
                .userDetailsService(whaleXCustomerDetailService)
                .authenticationManager(authenticationManager)
                .accessTokenConverter(jwtAccessTokenConverter)
                //该字段设置设置refresh token是否重复使用,true:reuse;false:no reuse.
                .reuseRefreshTokens(false)
                //自定义令牌派发者(需要将原有的令牌派发类加入)
                .tokenGranter(whaleXTokenGranter);
        //令牌增强
        if (jwtAccessTokenConverter != null && jwtTokenEnhancer != null){
            TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
            List<TokenEnhancer> enhancers = new ArrayList<>();
            enhancers.add(jwtTokenEnhancer);
            enhancers.add(jwtAccessTokenConverter);
            enhancerChain.setTokenEnhancers(enhancers);
            endpoints.tokenEnhancer(enhancerChain);
        }
    }

}
