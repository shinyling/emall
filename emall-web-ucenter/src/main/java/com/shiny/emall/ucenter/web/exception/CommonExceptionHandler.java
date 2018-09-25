package com.shiny.emall.ucenter.web.exception;

import com.shiny.emall.common.vo.JsonResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author DELL shiny
 * @create 2018/9/25
 */
@ControllerAdvice
@Log4j2
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult exceptionHandler(Exception e){
        return JsonResult.failure(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public JsonResult handleBindException(MethodArgumentNotValidException ex) {
        StringBuilder stringBuilder = new StringBuilder();
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.info("参数校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        stringBuilder.append(fieldError.getField());
        stringBuilder.append(":");
        stringBuilder.append(fieldError.getDefaultMessage());
        stringBuilder.append(".");
        return JsonResult.failure(stringBuilder.toString());
    }


    @ExceptionHandler(BindException.class)
    @ResponseBody
    public JsonResult handleBindException(BindException ex) {
        //校验 除了 requestbody 注解方式的参数校验 对应的 bindingresult 为 BeanPropertyBindingResult
        StringBuilder stringBuilder = new StringBuilder();
        ex.getAllErrors().stream().forEach(error -> {
            FieldError fieldError= (FieldError) error;
            log.info("字段:{},错误信息:{}", fieldError.getField(), fieldError.getDefaultMessage());
            stringBuilder.append(fieldError.getField());
            stringBuilder.append(":");
            stringBuilder.append(fieldError.getDefaultMessage());
            stringBuilder.append(".");
        });
        return JsonResult.failure(stringBuilder.toString());
    }
}
