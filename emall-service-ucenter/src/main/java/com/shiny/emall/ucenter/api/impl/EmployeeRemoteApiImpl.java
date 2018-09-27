package com.shiny.emall.ucenter.api.impl;

import com.shiny.emall.common.ucenter.entity.Employee;
import com.shiny.emall.common.utils.IdUtils;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.api.EmployeeRemoteApi;
import com.shiny.emall.ucenter.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
@RestController
public class EmployeeRemoteApiImpl implements EmployeeRemoteApi {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public JsonResult employeeAdd(@RequestBody Employee employee) {
        int exists=employeeMapper.selectByCompanyIdAndEmployeeCode(employee);
        if(exists>0){
            return JsonResult.failure("员工已存在");
        }
        employee.setId(IdUtils.id());
        int count=employeeMapper.insert(employee);
        if(count==0){
            return JsonResult.failure();
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult employeeList() {
        return JsonResult.ok(employeeMapper.selectAll());
    }
}
