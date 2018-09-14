package com.shiny.emall.ucenter.api.impl;

import com.shiny.emall.common.ucenter.entity.UcUser;
import com.shiny.emall.common.utils.IdUtils;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.api.UserRemoteApi;
import com.shiny.emall.ucenter.dao.UcUserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/9/5
 */
@Log4j2
@RestController
public class UserRemoteApiImpl implements UserRemoteApi {

    @Autowired
    private UcUserMapper userMapper;

    @Override
    public JsonResult addUser(@RequestBody UcUser user) {
        String id=IdUtils.id();
        user.setId(id);
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setDeleted(0);
        user.setStatus(1);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
        return JsonResult.ok(user);
    }

    @Override
    public JsonResult<UcUser> findByUsername(@RequestParam("username") String username) {
        UcUser user=userMapper.selectByUsername(username);
        return JsonResult.ok(user);
    }

    @Override
    public JsonResult<List<UcUser>> list() {
        List<UcUser> ucUsers=userMapper.selectAll();
        return JsonResult.ok(ucUsers);
    }

}
