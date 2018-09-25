package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcRoleButton;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcRoleButtonMapper {
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("buttonId") String buttonId);

    int insert(UcRoleButton record);

    List<UcRoleButton> selectAll();

    int checkExists(@Param("roleId") String roleId,@Param("buttonId") String buttonId);
}