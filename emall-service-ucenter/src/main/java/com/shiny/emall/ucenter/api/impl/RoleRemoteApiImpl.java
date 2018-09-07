package com.shiny.emall.ucenter.api.impl;

import com.shiny.emall.common.ucenter.entity.UcRole;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.api.RoleRemoteApi;
import com.shiny.emall.ucenter.dao.UcRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public JsonResult getRolesByUserId(String userId) {
        List<UcRole> roleList=roleMapper.selectRolesByUserId(userId);
        return new JsonResult(roleList);
    }
}
