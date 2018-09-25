package com.shiny.emall.ucenter.api.impl;

import com.shiny.emall.common.ucenter.entity.UcMenu;
import com.shiny.emall.common.ucenter.vo.MenuVo;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.api.PermissionRemoteApi;
import com.shiny.emall.ucenter.dao.UcMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public JsonResult findPermissionsByRoleId(String roleId) {
        List<UcMenu> menuList=menuMapper.selectMenusByRoleId(roleId);
        return new JsonResult(menuList);
    }

}
