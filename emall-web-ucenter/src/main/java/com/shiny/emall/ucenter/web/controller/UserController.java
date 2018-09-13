package com.shiny.emall.ucenter.web.controller;

import com.shiny.emall.common.ucenter.entity.UcUser;
import com.shiny.emall.common.vo.JsonResult;
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
    public JsonResult addUser(@RequestBody UcUser user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "/user/findByUsername/{username}",method = RequestMethod.GET)
    public JsonResult findByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }

    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    public JsonResult list(){
        return userService.list();
    }
}
