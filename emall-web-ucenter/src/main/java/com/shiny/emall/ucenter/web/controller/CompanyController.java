package com.shiny.emall.ucenter.web.controller;

import com.shiny.emall.common.ucenter.entity.Company;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.web.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author DELL shiny
 * @create 2018/9/25
 */
@Api(value = "CompanyController",tags = "公司")
@RestController
@Log4j2
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @ApiOperation(value = "添加公司")
    @RequestMapping(value = "company",method = RequestMethod.POST)
    public JsonResult companyAdd(@Valid @RequestBody Company company){
        return companyService.companyAdd(company);
    }

    @ApiOperation("查看公司列表")
    @RequestMapping(value = "company",method = RequestMethod.GET)
    public JsonResult companyList(){
        return companyService.companyList();
    }
}
