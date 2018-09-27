package com.shiny.emall.ucenter.api;

import com.shiny.emall.common.ucenter.entity.Dept;
import com.shiny.emall.common.vo.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by DELL on 2018/9/27.
 */
public interface DeptRemoteApi {

    @RequestMapping(value = "dept",method = RequestMethod.POST)
    JsonResult deptAdd(@RequestBody Dept dept);

    @RequestMapping(value = "dept",method = RequestMethod.GET)
    JsonResult deptList();
}
