package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcRole;
import java.util.List;

public interface UcRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(UcRole record);

    UcRole selectByPrimaryKey(String id);

    List<UcRole> selectAll();

    int updateByPrimaryKey(UcRole record);

    List<UcRole> selectRolesByUserId(String userId);
}