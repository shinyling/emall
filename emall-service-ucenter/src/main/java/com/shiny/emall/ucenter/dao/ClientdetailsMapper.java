package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.Clientdetails;
import java.util.List;

public interface ClientdetailsMapper {
    int deleteByPrimaryKey(String appid);

    int insert(Clientdetails record);

    Clientdetails selectByPrimaryKey(String appid);

    List<Clientdetails> selectAll();

    int updateByPrimaryKey(Clientdetails record);
}