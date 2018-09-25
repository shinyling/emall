package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.User;
import com.shiny.emall.common.ucenter.vo.UserVo;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    UserVo selectVoByUserId(String userId);

    User selectByUserId(String userId);
}