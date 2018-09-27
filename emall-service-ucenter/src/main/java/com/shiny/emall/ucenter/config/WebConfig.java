package com.shiny.emall.ucenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public RequestInterceptor requestInterceptor(){
        return new RequestInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor()).addPathPatterns("/**");
    }
}
