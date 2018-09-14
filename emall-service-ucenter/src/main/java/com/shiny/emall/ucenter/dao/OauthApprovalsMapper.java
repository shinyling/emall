package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.OauthApprovals;
import java.util.List;

public interface OauthApprovalsMapper {
    int insert(OauthApprovals record);

    List<OauthApprovals> selectAll();
}