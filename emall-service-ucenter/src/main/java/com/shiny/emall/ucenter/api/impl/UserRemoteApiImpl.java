package com.shiny.emall.ucenter.api.impl;

import com.shiny.emall.common.ucenter.entity.UcButton;
import com.shiny.emall.common.ucenter.entity.UcUser;
import com.shiny.emall.common.ucenter.entity.User;
import com.shiny.emall.common.ucenter.vo.AddUserVo;
import com.shiny.emall.common.ucenter.vo.MenuVo;
import com.shiny.emall.common.ucenter.vo.UserVo;
import com.shiny.emall.common.utils.IdUtils;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.api.UserRemoteApi;
import com.shiny.emall.ucenter.dao.UcButtonMapper;
import com.shiny.emall.ucenter.dao.UcMenuMapper;
import com.shiny.emall.ucenter.dao.UcUserMapper;
import com.shiny.emall.ucenter.dao.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private UserMapper infoMapper;

    @Autowired
    private UcMenuMapper menuMapper;

    @Autowired
    private UcButtonMapper buttonMapper;

    @Override
    public JsonResult addUser(@RequestBody AddUserVo addUserVo) {
        UcUser ucUser=new UcUser();
        String id=IdUtils.id();
        ucUser.setId(id);
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        ucUser.setUsername(addUserVo.getUsername());
        ucUser.setPassword(encoder.encode(addUserVo.getPassword()));
        ucUser.setDeleted(0);
        ucUser.setStatus(1);
        ucUser.setCreateTime(new Date());
        ucUser.setUpdateTime(new Date());
        int count=userMapper.insert(ucUser);
        if(count==0){
            return JsonResult.failure("添加用户失败");
        }
        User user=new User();
        user.setUserName(addUserVo.getUsername());
        user.setSex(addUserVo.getSex());
        user.setIdcard(addUserVo.getIdcard());
        user.setEmail(addUserVo.getEmail());
        user.setId(IdUtils.id());
        user.setBirthday(addUserVo.getBirthday());
        user.setAvatar(addUserVo.getAvatar());
        user.setUserId(id);
        infoMapper.insert(user);
        return JsonResult.ok();
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

    @Override
    public JsonResult getUserInfo(@RequestParam("username") String username) {
        UcUser ucUser=userMapper.selectByUsername(username);
        if(ucUser!=null){
            UserVo userVo=infoMapper.selectVoByUserId(ucUser.getId());
            if(userVo!=null){
                String userId=userVo.getId();
                List<MenuVo> menuVos=menuMapper.selectMenusByUserId(userId);
                userVo.setMenus(menuVos);
                List<UcButton> resourceVos=buttonMapper.selectButtonsByUserId(userId);
                userVo.setResources(resourceVos);
            }
            return JsonResult.ok(userVo);
        }
        return JsonResult.failure("未查询到数据");
    }

}
