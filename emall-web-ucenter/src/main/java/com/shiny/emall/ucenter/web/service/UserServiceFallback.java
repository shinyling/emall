package com.shiny.emall.ucenter.web.service;

import com.shiny.emall.common.ucenter.entity.User;

/**
 * @author DELL shiny
 * @create 2018/9/5
 */
public class UserServiceFallback implements UserService {
    @Override
    public User addUser(User user) {
        System.out.println("服务降级");
        return null;
    }
}
