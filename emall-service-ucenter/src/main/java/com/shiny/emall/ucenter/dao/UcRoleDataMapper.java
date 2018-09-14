package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.UcRoleData;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcRoleDataMapper {
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("dataId") String dataId);

    int insert(UcRoleData record);

    List<UcRoleData> selectAll();
}