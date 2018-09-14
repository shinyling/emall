package com.shiny.emall.ucenter.web.controller;

import com.shiny.emall.common.ucenter.entity.UcUser;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.web.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author DELL shiny
 * @create 2018/9/5
 */
@Log4j2
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public JsonResult addUser(@Valid @RequestBody UcUser user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder stringBuilder=new StringBuilder();
            bindingResult.getAllErrors().stream().forEach(error -> {
                FieldError fieldError= (FieldError) error;
                log.info("字段:{},错误信息:{}",fieldError.getField(),fieldError.getDefaultMessage());
                stringBuilder.append(fieldError.getField());
                stringBuilder.append(":");
                stringBuilder.append(fieldError.getDefaultMessage());
                stringBuilder.append(".");
            });
            return JsonResult.failure(stringBuilder.toString());
        }
        return userService.addUser(user);
    }

    @RequestMapping(value = "/user/findByUsername/{username}",method = RequestMethod.GET)
    public JsonResult findByUsername(@PathVariable String username){
        if(StringUtils.isEmpty(username)){
            return JsonResult.failure("参数不能为空");
        }
        return userService.findByUsername(username);
    }

    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    public JsonResult list(){
        return userService.list();
    }
}
