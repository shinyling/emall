package com.shiny.emall.ucenter.api;

import com.shiny.emall.common.ucenter.entity.UcData;
import com.shiny.emall.common.vo.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
public interface DataRemoteApi {

    @RequestMapping(value = "data",method = RequestMethod.POST)
    JsonResult dataAdd(@RequestBody UcData data);

    @RequestMapping(value = "data",method = RequestMethod.GET)
    JsonResult dataList();

    @RequestMapping(value = "roleData",method = RequestMethod.POST)
    JsonResult roleData(@RequestParam("roleId") String roleId,@RequestParam("dataId") String dataId);
}
