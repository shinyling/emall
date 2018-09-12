package com.shiny.emall.ucenter.api;

import com.shiny.emall.common.vo.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author DELL shiny
 * @create 2018/9/7
 */
public interface RoleRemoteApi {

    @RequestMapping(value = "/getRolesByUserId",method = RequestMethod.POST)
    JsonResult getRolesByUserId(String userId);
}
