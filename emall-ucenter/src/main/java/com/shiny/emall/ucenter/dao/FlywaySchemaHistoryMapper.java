package com.shiny.emall.ucenter.dao;

import com.shiny.emall.ucenter.entity.FlywaySchemaHistory;
import java.util.List;

public interface FlywaySchemaHistoryMapper {
    int deleteByPrimaryKey(Integer installedRank);

    int insert(FlywaySchemaHistory record);

    FlywaySchemaHistory selectByPrimaryKey(Integer installedRank);

    List<FlywaySchemaHistory> selectAll();

    int updateByPrimaryKey(FlywaySchemaHistory record);
}