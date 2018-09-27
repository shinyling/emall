package com.shiny.emall.ucenter.web.controller;

import com.shiny.emall.common.ucenter.entity.UcButton;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.web.service.ButtonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
@Api(value = "ButtonController",tags = "按钮")
@RestController
public class ButtonController {

    @Autowired
    private ButtonService buttonService;

    @RequestMapping(value = "button",method = RequestMethod.POST)
    public JsonResult buttonAdd(@Valid @RequestBody UcButton ucButton){
        return buttonService.buttonAdd(ucButton);
    }

    @RequestMapping(value = "button",method = RequestMethod.GET)
    public JsonResult buttonList(){
        return buttonService.buttonList();
    }

    @RequestMapping(value = "role/{roleId}/button/{buttonId}",method = RequestMethod.POST)
    public JsonResult roleButton(@PathVariable("roleId")String roleId,@PathVariable("buttonId")String buttonId){
        return buttonService.roleButton(roleId,buttonId);
    }
}
