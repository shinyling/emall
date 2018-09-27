package com.shiny.emall.ucenter.web.controller;

import com.shiny.emall.common.ucenter.entity.UcData;
import com.shiny.emall.common.vo.JsonResult;
import com.shiny.emall.ucenter.web.service.DataService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author DELL shiny
 * @create 2018/9/27
 */
@Api(value = "DataController",tags = "数据权限")
@RestController
public class DataController {

    @Autowired
    private DataService dataService;

    @RequestMapping(value = "data",method = RequestMethod.POST)
    public JsonResult dataAdd(@Valid @RequestBody UcData ucData){
        return dataService.dataAdd(ucData);
    }

    @RequestMapping(value = "data",method = RequestMethod.GET)
    public JsonResult dataList(){
        return dataService.dataList();
    }

    @RequestMapping(value = "role/{roleId}/data/{dataId}",method = RequestMethod.POST)
    public JsonResult roleData(@PathVariable("roleId")String roleId,@PathVariable("dataId")String dataId){
        return dataService.roleData(roleId,dataId);
    }
}
