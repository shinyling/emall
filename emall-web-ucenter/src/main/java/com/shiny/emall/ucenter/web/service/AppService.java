package com.shiny.emall.ucenter.web.service;

import com.shiny.emall.ucenter.api.AppRemoteApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author shiny
 */
@FeignClient(serviceId = "emall-service-ucenter")
public interface AppService extends AppRemoteApi {
}
