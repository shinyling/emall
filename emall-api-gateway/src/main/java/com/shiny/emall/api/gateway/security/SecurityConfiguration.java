package com.shiny.emall.api.gateway.security;

import com.shiny.emall.api.gateway.filter.ApiRequestDecorator;
import com.shiny.emall.api.gateway.filter.ApiTokenAccessFilter;
import com.shiny.emall.api.gateway.filter.ForwardHeaderFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

/**
 * @author DELL shiny
 * @create 2018/9/12
 */
@Configuration
@EnableOAuth2Sso
@Order(value = 0)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private ResourceServerTokenServices resourceServerTokenServices;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/index.html", "/home.html", "/", "/login","/swagger-ui.html","/swagger-resources/**","/v2/api-docs").permitAll()
                .anyRequest().authenticated()
                .antMatchers(HttpMethod.POST).authenticated()
                .and()
                .logout()
                .and()
                .addFilterBefore(new ApiTokenAccessFilter(resourceServerTokenServices), AbstractPreAuthenticatedProcessingFilter.class);
    }

    @Bean
    public ApiRequestDecorator apiRequestDecorator() {
        return new ApiRequestDecorator();
    }

    @Bean
    public ForwardHeaderFilter forwardHeaderFilter() {
        return new ForwardHeaderFilter();
    }

}


