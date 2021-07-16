package com.monitor.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.monitor.po.ResourcesInfo;
import com.monitor.po.ServerState;
import com.monitor.service.ResourceService;
import com.monitor.service.ServerStateService;
import com.monitor.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "服务状态")
@RequestMapping(value = "/ServerState")
public class ServerStateController {
    @Autowired
    private ServerStateService serverStateService;

    @ApiOperation( "插入服务状态")
    @RequestMapping(value = "/insert", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public R insert(@RequestBody JSONObject json) {
        log.info("insert-----------");
        try {
            if (StringUtils.isEmpty(json.getString("PROGRAM"))) {
                return R.error(String.format("%s 不能为空！", "PROGRAM"));
            }
            else if (StringUtils.isEmpty(json.getString("FUN_DES"))) {
                return R.error(String.format("%s 不能为空！", "FUN_DES"));
            }
            else if (StringUtils.isEmpty(json.getString("RUN_STATE"))) {
                return R.error(String.format("%s 不能为空！", "RUN_STATE"));
            }
            else if (StringUtils.isEmpty(json.getString("PROCESS"))) {
                return R.error(String.format("%s 不能为空！", "PROCESS"));
            }
            else if (StringUtils.isEmpty(json.getString("IP"))) {
                return R.error(String.format("%s 不能为空！", "IP"));
            }
            String PROGRAM = json.getString("PROGRAM");
            String FUN_DES = json.getString("FUN_DES");
            String RUN_STATE = json.getString("RUN_STATE");
            String DETAILS = json.getString("DETAILS");
            String IP = json.getString("IP");
            String PROCESS = json.getString("PROCESS");
            Timestamp COLL_TIME = json.getTimestamp("COLL_TIME");

            java.util.Date UP_TIME = new java.util.Date();
            ServerState ser= new ServerState();
            ser.setIp(IP); ser.setProgram(PROGRAM);ser.setProcess(PROCESS);ser.setCollTime(COLL_TIME);
            ser.setFunDes(FUN_DES);ser.setRunState(RUN_STATE);ser.setDetails(DETAILS);
            int result = serverStateService.insert(ser);
            return R.ok().put("data", result);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return R.error(e.getMessage());
        }
    }

    @ApiOperation( "查询所有服务状态数据")
    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
    public R getAll(){
        try {
            List<ServerState> actions = serverStateService.getAllActions();
            return R.ok().put("data", actions);
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return R.error(e.getMessage());
        }
    }
    @ApiOperation( "查询IP对应的服务状态")
    @RequestMapping(value = "/getInfoByIP",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public R getInfoByIP(@RequestBody JSONObject json){
        log.info("insert-----------"+json);
        try {
            if (json == null ||StringUtils.isEmpty(json.getString("ip"))) {
                return R.error(String.format("%s 不能为空！", "ids"));
            }
            String  ip = json.getString("ip");
            List<ServerState> result = serverStateService.getInfoByIP(ip);
            return R.ok().put("data", result);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return R.error(e.getMessage());
        }
    }

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
