package com.shiny.emall.ucenter.web.service;

import com.shiny.emall.common.ucenter.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author DELL shiny
 * @create 2018/9/5
 */
@Component
public class UserServiceFallback implements UserService {
    @Override
    public User addUser(User user) {
        System.out.println("服务降级");
        return null;
    }
}
