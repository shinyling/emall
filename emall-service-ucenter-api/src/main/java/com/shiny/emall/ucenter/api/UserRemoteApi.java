package com.shiny.emall.ucenter.api;

import com.shiny.emall.common.ucenter.entity.UcUser;
import com.shiny.emall.common.vo.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/9/5
 */
public interface UserRemoteApi {

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    JsonResult addUser(@RequestBody UcUser user);

    @RequestMapping(value = "/findByUsername",method = RequestMethod.POST)
    JsonResult<UcUser> findByUsername(@RequestParam("username") String username);

    @RequestMapping(value = "list",method = RequestMethod.GET)
    JsonResult<List<UcUser>> list();
}
