package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcRoleMenu;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcRoleMenuMapper {
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("menuId") String menuId);

    int insert(UcRoleMenu record);

    List<UcRoleMenu> selectAll();
}