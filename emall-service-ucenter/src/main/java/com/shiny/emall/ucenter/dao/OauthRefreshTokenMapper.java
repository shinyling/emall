package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.OauthRefreshToken;
import java.util.List;

public interface OauthRefreshTokenMapper {
    int insert(OauthRefreshToken record);

    List<OauthRefreshToken> selectAll();
}