package com.shiny.emall.ucenter.api;

import com.shiny.emall.common.ucenter.entity.Company;
import com.shiny.emall.common.vo.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author DELL shiny
 * @create 2018/9/25
 */
public interface CompanyRemoteApi {

    @RequestMapping(value = "company",method = RequestMethod.POST)
    JsonResult companyAdd(@RequestBody Company company);

    @RequestMapping(value = "company",method = RequestMethod.GET)
    JsonResult companyList();
}
