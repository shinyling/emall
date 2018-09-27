package com.shiny.emall.ucenter.api;

import com.shiny.emall.common.ucenter.entity.UcButton;
import com.shiny.emall.common.vo.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
public interface ButtonRemoteApi {

    @RequestMapping(value = "button",method = RequestMethod.POST)
    JsonResult buttonAdd(@RequestBody UcButton button);

    @RequestMapping(value = "button",method = RequestMethod.GET)
    JsonResult buttonList();

    @RequestMapping(value = "roleButton",method = RequestMethod.POST)
    JsonResult roleButton(@RequestParam("roleId") String roleId,@RequestParam("buttonId") String buttonId);
}
