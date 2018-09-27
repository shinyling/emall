package com.shiny.emall.ucenter.web.controller;

import com.shiny.emall.common.ucenter.vo.AddUserVo;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * @author DELL shiny
 * @create 2018/9/5
 */
@Api(value = "UserController",tags = "用户")
@Log4j2
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public JsonResult addUser(@Valid @RequestBody AddUserVo addUserVo){
        return userService.addUser(addUserVo);
    }

    @ApiOperation(value = "根据username查询用户信息")
    @RequestMapping(value = "/user/findByUsername/{username}",method = RequestMethod.GET)
    public JsonResult findByUsername(@PathVariable String username){
        if(StringUtils.isEmpty(username)){
            return JsonResult.failure("参数不能为空");
        }
        return userService.findByUsername(username);
    }

    @ApiOperation("获取用户列表")
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public JsonResult list(){
        return userService.list();
    }

    @ApiOperation(value = "根据登陆用户查询用户信息")
    @RequestMapping(value = "/user/info",method = RequestMethod.GET)
    public JsonResult getUserInfo(Principal user){
        String username=user.getName();
        if(StringUtils.isNotEmpty(username)){
            return userService.getUserInfo(username);
        }
        return JsonResult.failure("信息错误");
    }
}
