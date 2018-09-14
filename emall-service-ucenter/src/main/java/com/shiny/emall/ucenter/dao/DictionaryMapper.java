package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.Dictionary;
import java.util.List;

public interface DictionaryMapper {
    int deleteByPrimaryKey(String id);

    int insert(Dictionary record);

    Dictionary selectByPrimaryKey(String id);

    List<Dictionary> selectAll();

    int updateByPrimaryKey(Dictionary record);
}