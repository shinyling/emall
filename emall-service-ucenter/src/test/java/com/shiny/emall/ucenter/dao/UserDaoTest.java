package com.shiny.emall.ucenter.dao;

import com.shiny.emall.common.ucenter.entity.*;
import com.shiny.emall.common.utils.IdUtils;
import com.shiny.emall.ucenter.UcenterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UcenterApplication.class)
public class UserDaoTest {

    @Autowired
    private UcUserMapper ucUserMapper;

    @Autowired
    private UcRoleMapper ucRoleMapper;

    @Autowired
    private UcUserRoleMapper ucUserRoleMapper;

    @Autowired
    private UcMenuMapper ucMenuMapper;

    @Autowired
    private UcRoleMenuMapper ucRoleMenuMapper;

    @Test
    public void initAuthSystem(){
        String userId=null;
        UcUser ucUser=ucUserMapper.selectByUsername("shiny");
        if(ucUser==null){
            ucUser=new UcUser();
            userId=IdUtils.id();
            ucUser.setId(userId);
            ucUser.setUpdateTime(new Date());
            ucUser.setCreateTime(new Date());
            ucUser.setPassword(new BCryptPasswordEncoder().encode("123456"));
            ucUser.setPhone("13786132605");
            ucUser.setStatus(1);
            ucUser.setDeleted(0);
            ucUser.setUsername("shiny");
            ucUserMapper.insert(ucUser);
        }else {
            userId=ucUser.getId();
        }
        String roleId=null;
        UcRole ucRole=ucRoleMapper.selectByValue("ADMIN");
        if(ucRole==null){
            ucRole=new UcRole();
            roleId=IdUtils.id();
            ucRole.setId(roleId);
            ucRole.setCreateTime(new Date());
            ucRole.setName("超级管理员");
            ucRole.setValue("ADMIN");
            ucRole.setStatus(1);
            ucRoleMapper.insert(ucRole);
        }else {
            roleId=ucRole.getId();
        }
        String menuId=null;
        UcMenu ucMenu=ucMenuMapper.selectMenuByPath("/home");
        if(ucMenu==null){
            menuId=IdUtils.id();
            ucMenu=new UcMenu();
            ucMenu.setId(menuId);
            ucMenu.setName("主页");
            ucMenu.setCode("HOME");
            ucMenu.setLevel(0);
            ucMenu.setSort(0);
            ucMenu.setStatus(1);
            ucMenu.setUrl("/home");
            ucMenuMapper.insert(ucMenu);
        }else {
            menuId=ucMenu.getId();
        }
        int countUR=ucUserRoleMapper.checkExists(userId,roleId);
        if(countUR==0){
            UcUserRole userRole=new UcUserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            ucUserRoleMapper.insert(userRole);
        }
        int countRM=ucRoleMenuMapper.checkExists(roleId,menuId);
        if(countRM==0){
            UcRoleMenu roleMenu=new UcRoleMenu();
            roleMenu.setMenuId(menuId);
            roleMenu.setRoleId(roleId);
            ucRoleMenuMapper.insert(roleMenu);
        }
    }
}
