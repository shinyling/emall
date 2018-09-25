package com.shiny.emall.ucenter.web.service;

import com.shiny.emall.ucenter.api.UserRemoteApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author DELL shiny
 * @create 2018/9/5
 */
@FeignClient(value = "emall-service-ucenter",fallback = UserServiceFallback.class)
public interface UserService extends UserRemoteApi {

}
