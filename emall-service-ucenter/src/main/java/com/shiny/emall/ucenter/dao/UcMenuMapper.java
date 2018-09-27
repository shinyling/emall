package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcMenu;
import com.shiny.emall.common.ucenter.vo.MenuVo;

import java.awt.*;
import java.util.List;

public interface UcMenuMapper {
    int deleteByPrimaryKey(String id);

    List<UcMenu> selectMenusByRoleId(String roleId);

    int insert(UcMenu record);

    UcMenu selectByPrimaryKey(String id);

    int updateByPrimaryKey(UcMenu record);

    UcMenu selectMenuByPath(String path);

    List<MenuVo> selectMenusByUserId(String userId);

    List<UcMenu> selectAll();
}