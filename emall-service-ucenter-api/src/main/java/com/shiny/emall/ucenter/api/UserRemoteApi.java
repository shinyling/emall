package com.shiny.emall.ucenter.api;

import com.shiny.emall.common.ucenter.entity.UcUser;
import com.shiny.emall.common.vo.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author DELL shiny
 * @create 2018/9/5
 */
public interface UserRemoteApi {

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    JsonResult addUser(UcUser user);

    @RequestMapping(value = "/findByUsername",method = RequestMethod.GET)
    JsonResult findByUsername(String username);
}
