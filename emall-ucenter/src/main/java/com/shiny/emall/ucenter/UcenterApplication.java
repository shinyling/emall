package com.shiny.emall.ucenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author DELL shiny
 * @create 2018/9/3
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UcenterApplication.class,args);
    }
}
