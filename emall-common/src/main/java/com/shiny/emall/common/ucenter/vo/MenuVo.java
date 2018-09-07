package com.shiny.emall.common.ucenter.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author DELL shiny
 * @create 2018/9/7
 */
@Data
public class MenuVo implements Serializable{

    private String id;

    private String code;

    private String pCode;

    private String pId;

    private String name;

    private String url;

    private Integer level;

    private Integer sort;

    private Integer status;

    private String icon;

    private Date createTime;

    private Date updateTime;

}
