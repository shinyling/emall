package com.shiny.emall.ucenter.api.impl;

import com.shiny.emall.common.ucenter.entity.Company;
import com.shiny.emall.common.utils.IdUtils;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.api.CompanyRemoteApi;
import com.shiny.emall.ucenter.dao.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author DELL shiny
 * @create 2018/9/25
 */
@RestController
public class CompanyRemoteApiImpl implements CompanyRemoteApi{

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public JsonResult companyAdd(@RequestBody Company company) {
        int exists=companyMapper.selectByCompanyName(company);
        if(exists>0){
            return JsonResult.failure("公司已存在!");
        }
        company.setId(IdUtils.id());
        company.setCreateTime(new Date());
        int count=companyMapper.insert(company);
        if(count==0){
            return JsonResult.failure("新增公司失败");
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult companyList() {
        return JsonResult.ok(companyMapper.selectAll());
    }
}
