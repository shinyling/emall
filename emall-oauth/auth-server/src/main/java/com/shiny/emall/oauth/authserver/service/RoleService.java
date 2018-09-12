package com.shiny.emall.oauth.authserver.service;

import com.shiny.emall.ucenter.api.RoleRemoteApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author DELL shiny
 * @create 2018/9/7
 */
@FeignClient("emall-service-ucenter")
public interface RoleService extends RoleRemoteApi {
}
