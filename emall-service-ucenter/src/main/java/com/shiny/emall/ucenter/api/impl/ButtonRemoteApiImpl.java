package com.shiny.emall.ucenter.api.impl;

import com.shiny.emall.common.ucenter.entity.UcButton;
import com.shiny.emall.common.ucenter.entity.UcRoleButton;
import com.shiny.emall.common.utils.IdUtils;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.api.ButtonRemoteApi;
import com.shiny.emall.ucenter.dao.UcButtonMapper;
import com.shiny.emall.ucenter.dao.UcRoleButtonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
@RestController
public class ButtonRemoteApiImpl implements ButtonRemoteApi{

    @Autowired
    private UcButtonMapper ucButtonMapper;

    @Autowired
    private UcRoleButtonMapper ucRoleButtonMapper;

    @Override
    public JsonResult buttonAdd(@RequestBody UcButton button) {
        UcButton exits=ucButtonMapper.selectByButtonName(button.getButtonName());
        if(exits!=null){
            return JsonResult.failure("此按钮已存在");
        }
        button.setId(IdUtils.id());
        int count=ucButtonMapper.insert(button);
        if(count==0){
            return JsonResult.failure("添加按钮失败");
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult buttonList() {
        return JsonResult.ok(ucButtonMapper.selectAll());
    }

    @Override
    public JsonResult roleButton(String roleId, String buttonId) {
        UcRoleButton ucRoleButton=new UcRoleButton();
        ucRoleButton.setRoleId(roleId);
        ucRoleButton.setButtonId(buttonId);
        int count=ucRoleButtonMapper.insert(ucRoleButton);
        if(count==0){
            return JsonResult.failure("角色按钮绑定失败");
        }
        return JsonResult.ok();
    }
}
