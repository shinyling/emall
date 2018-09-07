package com.shiny.emall.api.gateway.service;

import com.shiny.emall.ucenter.api.PermissionRemoteApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author DELL shiny
 * @create 2018/9/7
 */
@FeignClient("emall-service-ucenter")
public interface PermissionService extends PermissionRemoteApi {
}
