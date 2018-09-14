package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcRoleCompany;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcRoleCompanyMapper {
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("companyId") String companyId);

    int insert(UcRoleCompany record);

    List<UcRoleCompany> selectAll();
}