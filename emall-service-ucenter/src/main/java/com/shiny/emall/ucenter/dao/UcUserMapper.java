package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcUser;
import java.util.List;

public interface UcUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(UcUser record);

    UcUser selectByPrimaryKey(String id);

    List<UcUser> selectAll();

    int updateByPrimaryKey(UcUser record);

    UcUser selectByUsername(String username);
}