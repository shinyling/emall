package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcMenu;
import java.util.List;

public interface UcMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(UcMenu record);

    UcMenu selectByPrimaryKey(String id);

    List<UcMenu> selectAll();

    int updateByPrimaryKey(UcMenu record);

    List<UcMenu> selectMenusByRoleId(String roleId);
}