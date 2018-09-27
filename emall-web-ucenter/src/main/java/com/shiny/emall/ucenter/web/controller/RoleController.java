package com.shiny.emall.ucenter.web.controller;

import com.shiny.emall.common.ucenter.entity.UcRole;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.web.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
@Api(value = "RoleController",tags = "角色")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "role",method = RequestMethod.POST)
    public JsonResult roleAdd(@Valid @RequestBody UcRole ucRole){
        return roleService.roleAdd(ucRole);
    }

    @RequestMapping(value = "role",method = RequestMethod.GET)
    public JsonResult roleList(){
        return roleService.roleList();
    }

    @RequestMapping(value = "user/{userId}/role/{roleId}",method = RequestMethod.POST)
    public JsonResult bindUserRole(@PathVariable("userId")String userId,@PathVariable("roleId")String roleId){
        return roleService.bindUserRole(userId,roleId);
    }
}
