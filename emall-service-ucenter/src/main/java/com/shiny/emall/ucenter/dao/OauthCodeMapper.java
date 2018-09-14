package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.OauthCode;
import java.util.List;

public interface OauthCodeMapper {
    int insert(OauthCode record);

    List<OauthCode> selectAll();
}