package com.shiny.emall.ucenter.api;

import com.shiny.emall.common.ucenter.entity.UcButton;
import com.shiny.emall.common.ucenter.entity.UcMenu;
import com.shiny.emall.common.vo.JsonResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author DELL shiny
 * @create 2018/9/7
 */
public interface PermissionRemoteApi {

    @RequestMapping(value = "findPermissionsByRoleId",method = RequestMethod.GET)
    JsonResult findPermissionsByRoleId(@RequestParam("roleId") String roleId);

    @RequestMapping(value = "permission",method = RequestMethod.POST)
    JsonResult permissionAdd(@RequestBody UcMenu ucMenu);

    @RequestMapping(value = "roleMenu",method = RequestMethod.POST)
    JsonResult roleMenu(@RequestParam("roleId") String roleId,@RequestParam("menuId") String menuId);

    @RequestMapping(value = "permission",method = RequestMethod.GET)
    JsonResult permissionList();
}
