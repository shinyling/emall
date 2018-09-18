package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcRole;
import java.util.List;

public interface UcRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(UcRole record);

    List<UcRole> selectRolesByUserId(String userId);

    UcRole selectByPrimaryKey(String id);

    int updateByPrimaryKey(UcRole record);

    UcRole selectByValue(String value);

}