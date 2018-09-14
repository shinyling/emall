package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcRoleEmployee;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcRoleEmployeeMapper {
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("employeeId") String employeeId);

    int insert(UcRoleEmployee record);

    List<UcRoleEmployee> selectAll();
}