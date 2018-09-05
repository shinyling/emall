package com.shiny.emall.ucenter.api.impl;

import com.shiny.emall.common.ucenter.entity.User;
import com.shiny.emall.common.utils.IdUtils;
import com.shiny.emall.ucenter.api.UserRemoteApi;
import com.shiny.emall.ucenter.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DELL shiny
 * @create 2018/9/5
 */
@RestController
public class UserRemoteApiImpl implements UserRemoteApi {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User addUser(@RequestBody User user) {
        String id=IdUtils.id();
        user.setId(id);
        userMapper.insert(user);
        return user;
    }
}
