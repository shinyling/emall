package com.shiny.emall.common.constants;

/**
 * @author DELL shiny
 * @create 2018/9/7
 */
public enum ResultCode {

    OK(200,"请求成功"),

    FAILURE(0,"请求失败");

    private Integer code;

    private String description;

    ResultCode(Integer code,String description){
        this.code=code;
        this.description=description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
