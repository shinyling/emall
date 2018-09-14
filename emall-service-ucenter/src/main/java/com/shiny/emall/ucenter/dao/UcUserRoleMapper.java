package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcUserRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserRoleMapper {
    int deleteByPrimaryKey(@Param("userId") String userId, @Param("roleId") String roleId);

    int insert(UcUserRole record);

    List<UcUserRole> selectAll();
}