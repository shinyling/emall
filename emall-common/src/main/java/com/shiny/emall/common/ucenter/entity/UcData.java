package com.shiny.emall.common.ucenter.entity;

import java.io.Serializable;

public class UcData implements Serializable {
    private String id;

    private String appId;

    private String dataCode;

    private String dataName;

    private String dataClass;

    private String dataExpression;

    private Integer orderNum;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode == null ? null : dataCode.trim();
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName == null ? null : dataName.trim();
    }

    public String getDataClass() {
        return dataClass;
    }

    public void setDataClass(String dataClass) {
        this.dataClass = dataClass == null ? null : dataClass.trim();
    }

    public String getDataExpression() {
        return dataExpression;
    }

    public void setDataExpression(String dataExpression) {
        this.dataExpression = dataExpression == null ? null : dataExpression.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appId=").append(appId);
        sb.append(", dataCode=").append(dataCode);
        sb.append(", dataName=").append(dataName);
        sb.append(", dataClass=").append(dataClass);
        sb.append(", dataExpression=").append(dataExpression);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}