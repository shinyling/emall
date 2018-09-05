package com.shiny.emall.ucenter.api;

import com.shiny.emall.common.ucenter.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author DELL shiny
 * @create 2018/9/5
 */
public interface UserRemoteApi {

    @RequestMapping(value = "/add/user",method = RequestMethod.POST)
    User addUser(User user);
}
