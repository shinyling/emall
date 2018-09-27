package com.shiny.emall.ucenter.web.controller;

import com.shiny.emall.common.ucenter.entity.UcMenu;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.web.service.MenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
@Api(value = "MenuController",tags = "菜单")
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "menu",method = RequestMethod.POST)
    public JsonResult menuAdd(@Valid @RequestBody UcMenu ucMenu){
        return menuService.permissionAdd(ucMenu);
    }

    @RequestMapping(value = "menu",method = RequestMethod.GET)
    public JsonResult menuList(){
        return menuService.permissionList();
    }

    @RequestMapping(value = "role/{roleId}/menu/{menuId}",method = RequestMethod.POST)
    public JsonResult roleMenu(@PathVariable("roleId")String roleId,@PathVariable("menuId")String menuId){
        return menuService.roleMenu(roleId,menuId);
    }
}
