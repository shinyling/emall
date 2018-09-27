package com.shiny.emall.ucenter.api.impl;

import com.shiny.emall.common.ucenter.entity.UcMenu;
import com.shiny.emall.common.ucenter.entity.UcRoleMenu;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.api.PermissionRemoteApi;
import com.shiny.emall.ucenter.dao.UcMenuMapper;
import com.shiny.emall.ucenter.dao.UcRoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/9/7
 */
@RestController
public class PermissionRemoteApiImpl implements PermissionRemoteApi{

    @Autowired
    private UcMenuMapper menuMapper;

    @Autowired
    private UcRoleMenuMapper ucRoleMenuMapper;

    @Override
    public JsonResult findPermissionsByRoleId(String roleId) {
        List<UcMenu> menuList=menuMapper.selectMenusByRoleId(roleId);
        return JsonResult.ok(menuList);
    }

    @Override
    public JsonResult permissionAdd(@RequestBody UcMenu ucMenu) {
        int count=menuMapper.insert(ucMenu);
        if(count==0){
            return JsonResult.failure();
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult roleMenu(String roleId, String menuId) {
        UcRoleMenu ucRoleMenu=new UcRoleMenu();
        ucRoleMenu.setRoleId(roleId);
        ucRoleMenu.setMenuId(menuId);
        int count=ucRoleMenuMapper.insert(ucRoleMenu);
        if(count==0){
            return JsonResult.failure("角色菜单绑定失败!");
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult permissionList() {
        return JsonResult.ok(menuMapper.selectAll());
    }

}
