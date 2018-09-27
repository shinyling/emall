package com.shiny.emall.ucenter.api.impl;

import com.shiny.emall.common.ucenter.entity.Dept;
import com.shiny.emall.common.utils.IdUtils;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.api.DeptRemoteApi;
import com.shiny.emall.ucenter.dao.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
@RestController
public class DeptRemoteApiImpl implements DeptRemoteApi {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public JsonResult deptAdd(@RequestBody Dept dept) {
        int exists=deptMapper.selectByCompanyIdAndDeptCode(dept);
        if(exists>0){
            return JsonResult.failure("该部门已存在");
        }
        dept.setId(IdUtils.id());
        dept.setCreateTime(new Date());
        int count=deptMapper.insert(dept);
        if(count==0){
            return JsonResult.failure();
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult deptList() {
        return JsonResult.ok(deptMapper.selectAll());
    }
}
