package com.shiny.emall.ucenter.web.service;

import com.shiny.emall.ucenter.api.CompanyRemoteApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author DELL shiny
 * @create 2018/9/25
 */
@FeignClient(value = "emall-service-ucenter")
public interface CompanyService extends CompanyRemoteApi {
}
