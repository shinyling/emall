package com.shiny.emall.ucenter.api;

import com.shiny.emall.common.ucenter.entity.UcRole;
import com.shiny.emall.common.ucenter.entity.UcUser;
import com.shiny.emall.common.vo.JsonResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author DELL shiny
 * @create 2018/9/7
 */
public interface RoleRemoteApi {

    @RequestMapping(value = "/getRolesByUserId",method = RequestMethod.GET)
    JsonResult getRolesByUserId(@RequestParam("userId") String userId);

    @RequestMapping(value = "role",method = RequestMethod.POST)
    JsonResult roleAdd(@RequestBody UcRole role);

    @RequestMapping(value = "role",method = RequestMethod.GET)
    JsonResult roleList();

    @RequestMapping(value = "userRole",method = RequestMethod.POST)
    JsonResult bindUserRole(@RequestParam("userId") String userId,@RequestParam("roleId") String roleId);
}
