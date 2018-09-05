package com.shiny.emall.ucenter.web.controller;

import com.shiny.emall.common.ucenter.entity.User;
import com.shiny.emall.ucenter.api.UserRemoteApi;
import com.shiny.emall.ucenter.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author DELL shiny
 * @create 2018/9/5
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
