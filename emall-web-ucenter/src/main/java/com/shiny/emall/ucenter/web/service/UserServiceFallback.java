package com.shiny.emall.ucenter.web.service;

import com.shiny.emall.common.ucenter.entity.UcUser;
import com.shiny.emall.common.vo.JsonResult;
import org.springframework.stereotype.Component;

/**
 * @author DELL shiny
 * @create 2018/9/5
 */
@Component
public class UserServiceFallback implements UserService {
    @Override
    public JsonResult addUser(UcUser user) {
        return JsonResult.failure("服务降级");
    }

    @Override
    public JsonResult findByUsername(String username) {
        return JsonResult.failure("服务降级");
    }
}
