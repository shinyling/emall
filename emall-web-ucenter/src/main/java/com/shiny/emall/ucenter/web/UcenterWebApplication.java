package com.shiny.emall.ucenter.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author DELL shiny
 * @create 2018/9/4
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class UcenterWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(UcenterWebApplication.class,args);
    }
}
