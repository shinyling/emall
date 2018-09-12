package com.shiny.emall.common.vo;

import com.shiny.emall.common.constants.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author DELL shiny
 * @create 2018/9/7
 */
@Data
public class JsonResult<T> implements Serializable {

    private Integer code;

    private String description;

    private T data;

    public JsonResult(){

    }

    public JsonResult(Integer code, String description,T data) {
        this.code = code;
        this.description = description;
        this.data=data;
    }

    public JsonResult(ResultCode resultCode){
        this.code=resultCode.getCode();
        this.description=resultCode.getDescription();
    }

    public JsonResult(T data){
        this.code=ResultCode.OK.getCode();
        this.description=ResultCode.OK.getDescription();
        this.data=data;
    }

    public JsonResult(ResultCode resultCode,String msg){
        this.code=resultCode.getCode();
        this.description=msg;
    }

    public static JsonResult ok(){
        return new JsonResult(ResultCode.OK);
    }

    public static JsonResult ok(String msg){
        return new JsonResult(ResultCode.OK,msg);
    }


    public static JsonResult failure(){
        return new JsonResult(ResultCode.FAILURE);
    }

    public static JsonResult failure(String msg){
        return new JsonResult(ResultCode.FAILURE,msg);
    }

}
