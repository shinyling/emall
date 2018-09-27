package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.Dept;
import java.util.List;

public interface DeptMapper {
    int deleteByPrimaryKey(String id);

    int insert(Dept record);

    Dept selectByPrimaryKey(String id);

    List<Dept> selectAll();

    int updateByPrimaryKey(Dept record);

    int selectByCompanyIdAndDeptCode(Dept dept);
}