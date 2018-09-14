package com.shiny.emall.common.ucenter.entity;

import java.io.Serializable;

public class UcApp implements Serializable {
    private String id;

    private String appName;

    private String secretKey;

    private String appLogo;

    private String indexUrl;

    private String userNotifyUrl;

    private String deptNotifyUrl;

    private String logoutNotifyUrl;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey == null ? null : secretKey.trim();
    }

    public String getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(String appLogo) {
        this.appLogo = appLogo == null ? null : appLogo.trim();
    }

    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl == null ? null : indexUrl.trim();
    }

    public String getUserNotifyUrl() {
        return userNotifyUrl;
    }

    public void setUserNotifyUrl(String userNotifyUrl) {
        this.userNotifyUrl = userNotifyUrl == null ? null : userNotifyUrl.trim();
    }

    public String getDeptNotifyUrl() {
        return deptNotifyUrl;
    }

    public void setDeptNotifyUrl(String deptNotifyUrl) {
        this.deptNotifyUrl = deptNotifyUrl == null ? null : deptNotifyUrl.trim();
    }

    public String getLogoutNotifyUrl() {
        return logoutNotifyUrl;
    }

    public void setLogoutNotifyUrl(String logoutNotifyUrl) {
        this.logoutNotifyUrl = logoutNotifyUrl == null ? null : logoutNotifyUrl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appName=").append(appName);
        sb.append(", secretKey=").append(secretKey);
        sb.append(", appLogo=").append(appLogo);
        sb.append(", indexUrl=").append(indexUrl);
        sb.append(", userNotifyUrl=").append(userNotifyUrl);
        sb.append(", deptNotifyUrl=").append(deptNotifyUrl);
        sb.append(", logoutNotifyUrl=").append(logoutNotifyUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}