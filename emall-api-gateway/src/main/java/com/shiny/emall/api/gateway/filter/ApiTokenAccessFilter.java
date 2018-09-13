package com.shiny.emall.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DELL shiny
 * @create 2018/9/6
 */
public class ApiTokenAccessFilter extends OAuth2AuthenticationProcessingFilter {

    public ApiTokenAccessFilter(ResourceServerTokenServices resourceServerTokenServices) {

        super();
        setStateless(false);
        setAuthenticationManager(oauthAuthenticationManager(resourceServerTokenServices));
    }

    private AuthenticationManager oauthAuthenticationManager(ResourceServerTokenServices tokenServices) {

        OAuth2AuthenticationManager oauthAuthenticationManager = new OAuth2AuthenticationManager();

        oauthAuthenticationManager.setResourceId("oauth2-resource");
        oauthAuthenticationManager.setTokenServices(tokenServices);
        oauthAuthenticationManager.setClientDetailsService(null);

        return oauthAuthenticationManager;
    }
}

