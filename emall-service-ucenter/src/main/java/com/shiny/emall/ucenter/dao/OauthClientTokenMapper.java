package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.OauthClientToken;
import java.util.List;

public interface OauthClientTokenMapper {
    int deleteByPrimaryKey(String authenticationId);

    int insert(OauthClientToken record);

    OauthClientToken selectByPrimaryKey(String authenticationId);

    List<OauthClientToken> selectAll();

    int updateByPrimaryKey(OauthClientToken record);
}