package com.shiny.emall.ucenter.web.controller;

import com.shiny.emall.common.ucenter.entity.UcApp;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.web.service.AppService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
@Api(value = "AppController",tags = "App")
@RestController
public class AppController {

    @Autowired
    private AppService appService;

    @RequestMapping(value = "app",method = RequestMethod.POST)
    public JsonResult appAdd(@Valid @RequestBody UcApp app){
        return appService.addApp(app);
    }

    @RequestMapping(value = "app",method = RequestMethod.GET)
    public JsonResult appList(){
        return appService.listApp();
    }
}
