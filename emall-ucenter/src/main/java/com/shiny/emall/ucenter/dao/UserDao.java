package com.shiny.emall.ucenter.dao;


import com.shiny.emall.ucenter.entity.User;

/**
 * @author DELL shiny
 * @create 2018/9/3
 */
public interface UserDao {

    User findById(String id);

}
