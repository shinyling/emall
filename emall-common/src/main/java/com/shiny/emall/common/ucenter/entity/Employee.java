package com.shiny.emall.common.ucenter.entity;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private String id;

    @NotBlank(message = "未注册不能加入")
    private String userId;

    private String companyId;

    @NotBlank(message = "部门不能为空")
    private String deptId;

    private Date createTime;

    @NotBlank(message = "员工编号不能为空")
    private String employeeCode;

    @NotBlank(message = "员工职位不能为空")
    private String employeePosition;

    private Date entryTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode == null ? null : employeeCode.trim();
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition == null ? null : employeePosition.trim();
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", companyId=").append(companyId);
        sb.append(", deptId=").append(deptId);
        sb.append(", createTime=").append(createTime);
        sb.append(", employeeCode=").append(employeeCode);
        sb.append(", employeePosition=").append(employeePosition);
        sb.append(", entryTime=").append(entryTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}