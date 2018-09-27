package com.shiny.emall.ucenter.api.impl;

import com.shiny.emall.common.ucenter.entity.UcData;
import com.shiny.emall.common.ucenter.entity.UcRoleData;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.api.DataRemoteApi;
import com.shiny.emall.ucenter.dao.UcDataMapper;
import com.shiny.emall.ucenter.dao.UcRoleDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
@RestController
public class DataRemoteApiImpl implements DataRemoteApi{

    @Autowired
    private UcDataMapper dataMapper;

    @Autowired
    private UcRoleDataMapper ucRoleDataMapper;

    @Override
    public JsonResult dataAdd(@RequestBody UcData data) {
        UcData exist=dataMapper.selectByDataName(data.getDataName());
        if(exist!=null){
            return JsonResult.failure("此数据已存在");
        }
        int count=dataMapper.insert(data);
        if(count==0){
            return JsonResult.failure("数据插入失败");
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult dataList() {
        return JsonResult.ok(dataMapper.selectAll());
    }

    @Override
    public JsonResult roleData(String roleId, String dataId) {
        UcRoleData ucRoleData=new UcRoleData();
        ucRoleData.setRoleId(roleId);
        ucRoleData.setDataId(dataId);
        int count=ucRoleDataMapper.insert(ucRoleData);
        if(count==0){
            return JsonResult.failure("角色数据权限绑定失败!");
        }
        return JsonResult.ok();
    }
}
