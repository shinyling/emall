package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcApp;
import java.util.List;

public interface UcAppMapper {
    int deleteByPrimaryKey(String id);

    int insert(UcApp record);

    UcApp selectByPrimaryKey(String id);

    List<UcApp> selectAll();

    int updateByPrimaryKey(UcApp record);
}