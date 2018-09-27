package com.shiny.emall.ucenter.api.impl;

import com.shiny.emall.common.ucenter.entity.Dept;
import com.shiny.emall.common.utils.IdUtils;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.UcenterApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author shiny
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UcenterApplication.class)
public class DeptRemoteApiImplTest {

    @Autowired
    private DeptRemoteApiImpl deptRemoteApi;

    @Test
    public void testDeptAdd(){
        Dept dept=new Dept();
        dept.setId(IdUtils.id());
        dept.setAddress("2楼");
        dept.setCreateTime(new Date());
        dept.setCompanyId("5ba9e5a74f216771fb6aea1f");
        dept.setDeptCode("0001");
        dept.setDeptName("董事局");
        dept.setTel("232342");
        dept.setZipCode("418000");
        JsonResult jsonResult=deptRemoteApi.deptAdd(dept);
        Assert.assertTrue(jsonResult.getCode().equals(200));
    }
}
