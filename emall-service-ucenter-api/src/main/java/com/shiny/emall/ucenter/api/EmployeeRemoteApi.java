package com.shiny.emall.ucenter.api;

import com.shiny.emall.common.ucenter.entity.Employee;
import com.shiny.emall.common.vo.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by DELL on 2018/9/27.
 */
public interface EmployeeRemoteApi {

    @RequestMapping(value = "employee",method = RequestMethod.POST)
    JsonResult employeeAdd(@RequestBody Employee employee);

    @RequestMapping(value = "employee",method = RequestMethod.GET)
    JsonResult employeeList();
}
