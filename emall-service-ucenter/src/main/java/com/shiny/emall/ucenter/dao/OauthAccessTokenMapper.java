package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.OauthAccessToken;
import java.util.List;

public interface OauthAccessTokenMapper {
    int deleteByPrimaryKey(String authenticationId);

    int insert(OauthAccessToken record);

    OauthAccessToken selectByPrimaryKey(String authenticationId);

    List<OauthAccessToken> selectAll();

    int updateByPrimaryKey(OauthAccessToken record);
}