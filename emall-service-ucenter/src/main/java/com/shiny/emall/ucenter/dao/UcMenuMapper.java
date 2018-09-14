package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcMenu;
import java.util.List;

public interface UcMenuMapper {
    int deleteByPrimaryKey(String id);

    List<UcMenu> selectMenusByRoleId(String roleId);

    int insert(UcMenu record);

    UcMenu selectByPrimaryKey(String id);

    int updateByPrimaryKey(UcMenu record);

}