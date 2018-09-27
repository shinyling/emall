package com.shiny.emall.ucenter.web.controller;

import com.shiny.emall.common.ucenter.entity.Employee;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.web.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
@Api(value = "EmployeeController",tags = "员工")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation("新增员工")
    @RequestMapping(value = "employee",method = RequestMethod.POST)
    public JsonResult employeeAdd(@Valid @RequestBody Employee employee){
        return employeeService.employeeAdd(employee);
    }

    @RequestMapping(value = "employee",method = RequestMethod.GET)
    public JsonResult employeeList(){
        return employeeService.employeeList();
    }
}
