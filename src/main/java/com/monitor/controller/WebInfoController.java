package com.monitor.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.monitor.po.ServerState;
import com.monitor.po.WebInfo;
import com.monitor.service.ServerStateService;
import com.monitor.service.WebInfoService;
import com.monitor.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Administrator on 2021/7/15.
 */
@Slf4j
@RestController
@Api(tags = "Web应用情况查询")
@RequestMapping(value = "/WebInfo")
public class WebInfoController {
    @Autowired
    private WebInfoService webInfoService;

    @ApiOperation( "插入Web应用数据")
    @RequestMapping(value = "/insert", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public R insert(@RequestBody JSONObject json) {
        log.info("insert-----------");
        try {
            if (StringUtils.isEmpty(json.getString("PAGE"))) {
                return R.error(String.format("%s 不能为空！", "PAGE"));
            }
            else if (StringUtils.isEmpty(json.getString("API_NAME"))) {
                return R.error(String.format("%s 不能为空！", "API_NAME"));
            }
            else if (StringUtils.isEmpty(json.getString("API_URL"))) {
                return R.error(String.format("%s 不能为空！", "API_URL"));
            } else if (json.getLong("NUMBER")<0) {
                return R.error(String.format("%s 不能为空！", "NUMBER"));
            }

            String PAGE = json.getString("PAGE");
            String API_NAME = json.getString("API_NAME");
            String API_URL = json.getString("API_URL");
           long number = json.getLong("NUMBER");
            Timestamp COLL_TIME = json.getTimestamp("COLL_TIME");

            java.util.Date UP_TIME = new java.util.Date();
            WebInfo web= new WebInfo();
            web.setPage(PAGE);
            web.setNumber(number);
           web.setApiName(API_NAME);web.setApiUrl(API_URL);
            web.setCollTime(COLL_TIME);web.setUpTime(UP_TIME);
            log.info("insert-------web----"+web);
            int result = webInfoService.insert(web);
            return R.ok().put("data", result);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return R.error(e.getMessage());
        }
    }

    @ApiOperation( "查询Web应用数据")
    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
    public R getAll(){
        try {
            List<WebInfo> actions = webInfoService.getAllActions();
            return R.ok().put("data", actions);
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return R.error(e.getMessage());
        }
    }
//    @ApiOperation( "查询Web应用数据")
//    @RequestMapping(value = "/getInfoByIP",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
//    public R getInfoByIP(@RequestBody JSONObject json){
//        log.info("insert-----------"+json);
//        try {
//            if (json == null ||StringUtils.isEmpty(json.getString("ip"))) {
//                return R.error(String.format("%s 不能为空！", "ids"));
//            }
//            String  ip = json.getString("ip");
//            List<ServerState> result = serverStateService.getInfoByIP(ip);
//            return R.ok().put("data", result);
//        } catch (Exception e) {
//            log.error(e.getLocalizedMessage());
//            return R.error(e.getMessage());
//        }
//    }

//    @ApiOperation( "查询当日的资源信息")
//    @RequestMapping(value = "/getNowAlarm",method = { RequestMethod.GET})
//    public R getNowAlarm(){
//        try {
//            List<AlarmInfo> actions = alarmService.getNowAlarm();
//            return R.ok().put("data", actions);
//        }
//        catch (Exception e) {
//            log.error(e.getLocalizedMessage());
//            return R.error(e.getMessage());
//        }
//    }

}
