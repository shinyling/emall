package com.shiny.emall.ucenter.api.impl;

import com.shiny.emall.common.ucenter.entity.UcRole;
import com.shiny.emall.common.ucenter.entity.UcUserRole;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.api.RoleRemoteApi;
import com.shiny.emall.ucenter.dao.UcRoleMapper;
import com.shiny.emall.ucenter.dao.UcUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/9/7
 */
@RestController
public class RoleRemoteApiImpl implements RoleRemoteApi {

    @Autowired
    private UcRoleMapper roleMapper;

    @Autowired
    private UcUserRoleMapper ucUserRoleMapper;

    @Override
    public JsonResult getRolesByUserId(String userId) {
        List<UcRole> roleList=roleMapper.selectRolesByUserId(userId);
        return new JsonResult(roleList);
    }

    @Override
    public JsonResult roleAdd(@RequestBody UcRole role) {
        int count= roleMapper.insert(role);
        if(count==0){
            return JsonResult.failure();
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult roleList() {
        return JsonResult.ok(roleMapper.selectAll());
    }

    @Override
    public JsonResult bindUserRole(String userId, String roleId) {
        UcUserRole ucUserRole=new UcUserRole();
        ucUserRole.setUserId(userId);
        ucUserRole.setRoleId(roleId);
        int count=ucUserRoleMapper.insert(ucUserRole);
        if(count==0){
            return JsonResult.failure("用户角色绑定失败!");
        }
        return JsonResult.ok();
    }
}
