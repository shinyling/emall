package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.OauthClientDetails;
import java.util.List;

public interface OauthClientDetailsMapper {
    int deleteByPrimaryKey(String clientId);

    int insert(OauthClientDetails record);

    OauthClientDetails selectByPrimaryKey(String clientId);

    List<OauthClientDetails> selectAll();

    int updateByPrimaryKey(OauthClientDetails record);
}