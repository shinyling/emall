package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcUser;

import java.util.List;

public interface UcUserMapper {

    int deleteByPrimaryKey(String id);

    UcUser selectByUsername(String username);

    int insert(UcUser record);

    UcUser selectByPrimaryKey(String id);

    int updateByPrimaryKey(UcUser record);

    List<UcUser> selectAll();
}