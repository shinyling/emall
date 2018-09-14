package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcData;
import java.util.List;

public interface UcDataMapper {
    int deleteByPrimaryKey(String id);

    int insert(UcData record);

    UcData selectByPrimaryKey(String id);

    List<UcData> selectAll();

    int updateByPrimaryKey(UcData record);
}