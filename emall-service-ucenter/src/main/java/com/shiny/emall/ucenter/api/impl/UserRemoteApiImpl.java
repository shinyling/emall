package com.shiny.emall.ucenter.api.impl;

import com.shiny.emall.common.ucenter.entity.UcUser;
import com.shiny.emall.common.utils.IdUtils;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.api.UserRemoteApi;
import com.shiny.emall.ucenter.dao.UcUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DELL shiny
 * @create 2018/9/5
 */
@RestController
public class UserRemoteApiImpl implements UserRemoteApi {

    @Autowired
    private UcUserMapper userMapper;

    @Override
    public JsonResult addUser(@RequestBody UcUser user) {
        String id=IdUtils.id();
        user.setId(id);
        userMapper.insert(user);
        return new JsonResult(user);
    }

    @Override
    public JsonResult<UcUser> findByUsername(@RequestParam("username") String username) {
        UcUser user=userMapper.selectByUsername(username);
        return new JsonResult(user);
    }

}
