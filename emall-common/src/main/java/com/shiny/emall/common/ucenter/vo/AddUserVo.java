package com.shiny.emall.common.ucenter.vo;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author DELL shiny
 * @create 2018/9/25
 */
@Data
public class AddUserVo implements Serializable{

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "电话号码不能为空")
    private String phone;

    @NotEmpty(message = "密码不能为空")
    private String password;

    private String avatar;

    private Integer sex;

    private Date birthday;

    private String email;

    private String idcard;
}
