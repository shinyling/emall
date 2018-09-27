package com.shiny.emall.ucenter.api;

import com.shiny.emall.common.ucenter.entity.UcUser;
import com.shiny.emall.common.ucenter.vo.AddUserVo;
import com.shiny.emall.common.vo.JsonResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author DELL shiny
 * @create 2018/9/5
 */
public interface UserRemoteApi {

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    JsonResult addUser(@RequestBody AddUserVo addUserVo);

    @RequestMapping(value = "/findByUsername",method = RequestMethod.GET)
    JsonResult<UcUser> findByUsername(@RequestParam("username") String username);

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    JsonResult<List<UcUser>> list();

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    JsonResult getUserInfo(@RequestParam("username") String username);
}
