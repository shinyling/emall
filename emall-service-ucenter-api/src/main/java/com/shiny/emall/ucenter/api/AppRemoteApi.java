package com.shiny.emall.ucenter.api;

import com.shiny.emall.common.ucenter.entity.UcApp;
import com.shiny.emall.common.vo.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author shiny
 */
public interface AppRemoteApi {

    @RequestMapping(value = "app",method = RequestMethod.POST)
    JsonResult addApp(@RequestBody UcApp ucApp);

    @RequestMapping(value = "app",method = RequestMethod.GET)
    JsonResult listApp();
}
