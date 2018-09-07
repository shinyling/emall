package com.shiny.emall.common.ucenter.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author DELL shiny
 * @create 2018/9/7
 */
@Data
public class UserVo implements Serializable {

    private String id;

    private String avatar;

    private String username;

    private String password;

    private String salt;

    private String name;

    private Date birthday;

    private Integer sex;

    private String email;

    private String phone;

    private Integer status;

    private Date createTime;

    private Date updateTime;
}
