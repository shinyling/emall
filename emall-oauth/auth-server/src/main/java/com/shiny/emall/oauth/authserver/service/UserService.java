package com.shiny.emall.oauth.authserver.service;

import com.shiny.emall.ucenter.api.UserRemoteApi;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "emall-service-ucenter")
public interface UserService extends UserRemoteApi {
}