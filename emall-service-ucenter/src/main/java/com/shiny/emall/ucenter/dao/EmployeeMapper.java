package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.Employee;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Employee record);

    Employee selectByPrimaryKey(String id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    int selectByCompanyIdAndEmployeeCode(Employee employee);
}