package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.Company;
import java.util.List;

public interface CompanyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Company record);

    Company selectByPrimaryKey(String id);

    List<Company> selectAll();

    int updateByPrimaryKey(Company record);

    int selectByCompanyName(Company company);
}