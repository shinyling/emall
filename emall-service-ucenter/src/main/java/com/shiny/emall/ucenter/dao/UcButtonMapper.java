package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcButton;
import java.util.List;

public interface UcButtonMapper {
    int deleteByPrimaryKey(String id);

    int insert(UcButton record);

    UcButton selectByPrimaryKey(String id);

    List<UcButton> selectAll();

    int updateByPrimaryKey(UcButton record);
}