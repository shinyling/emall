package com.shiny.emall.ucenter.web.controller;

import com.shiny.emall.common.ucenter.entity.Dept;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.web.service.DeptService;
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
@Api(value = "DeptController",tags = "部门")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @ApiOperation("添加部门(在公司下添加部门)")
    @RequestMapping(value = "dept",method = RequestMethod.POST)
    public JsonResult deptAdd(@Valid @RequestBody Dept dept){
        return deptService.deptAdd(dept);
    }

    @RequestMapping(value = "dept",method = RequestMethod.GET)
    public JsonResult deptList(){
        return deptService.deptList();
    }

}
