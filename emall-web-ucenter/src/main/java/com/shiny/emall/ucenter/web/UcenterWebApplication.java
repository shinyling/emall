package com.shiny.emall.ucenter.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author DELL shiny
 * @create 2018/9/4
 */
@EnableResourceServer
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
public class UcenterWebApplication {

    @Value("${swagger.enable}")
    private boolean swaggerEnable;

    public static void main(String[] args) {
        SpringApplication.run(UcenterWebApplication.class,args);
    }

    @Bean
    public Docket swaggerPersonApi10() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerEnable)
                .apiInfo(
                        new ApiInfoBuilder()
                                .version("1.0")
                                .title("ucenter API")
                                .description("ucenter API v1.0")
                                .build()
                )
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shiny.emall.ucenter.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
