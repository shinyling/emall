package com.shiny.emall.ucenter.web.service;

import com.shiny.emall.common.ucenter.entity.UcUser;
import com.shiny.emall.common.ucenter.vo.AddUserVo;
import com.shiny.emall.common.vo.JsonResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/9/5
 */
@Component
public class UserServiceFallback implements UserService {
    @Override
    public JsonResult addUser(AddUserVo addUserVo) {
        return JsonResult.failure("服务降级");
    }

    @Override
    public JsonResult findByUsername(String username) {
        return JsonResult.failure("服务降级");
    }

    @Override
    public JsonResult<List<UcUser>> list() {
        return JsonResult.failure("服务降级");
    }

    @Override
    public JsonResult getUserInfo(String username) {
        return JsonResult.failure("服务降级");
    }
}
