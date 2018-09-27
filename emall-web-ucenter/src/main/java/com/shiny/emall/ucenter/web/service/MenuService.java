package com.shiny.emall.ucenter.web.service;

import com.shiny.emall.ucenter.api.PermissionRemoteApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
@FeignClient(serviceId = "emall-service-ucenter")
public interface MenuService extends PermissionRemoteApi {
}
