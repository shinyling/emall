package com.shiny.emall.ucenter.api.impl;

import com.shiny.emall.common.ucenter.entity.UcApp;
import com.shiny.emall.common.utils.IdUtils;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.api.AppRemoteApi;
import com.shiny.emall.ucenter.dao.UcAppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
@RestController
public class AppRemoteApiImpl implements AppRemoteApi{

    @Autowired
    private UcAppMapper appMapper;

    @Override
    public JsonResult addApp(@RequestBody UcApp ucApp) {
        ucApp.setId(IdUtils.id());
        int count = appMapper.insert(ucApp);
        if(count==0){
            return JsonResult.failure();
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult listApp() {
        return JsonResult.ok(appMapper.selectAll());
    }
}
