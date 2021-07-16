package com.monitor.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.monitor.po.DataInfo;
import com.monitor.po.ServerState;
import com.monitor.service.DataInfoService;
import com.monitor.service.ServerStateService;
import com.monitor.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Administrator on 2021/7/15.
 */
@Slf4j
@RestController
@Api(tags = "历史数据")
@RequestMapping(value = "/DataInfo")
public class DataInfoController {
    @Autowired
    private DataInfoService dataInfoService;

    @ApiOperation( "插入历史数据")
    @RequestMapping(value = "/insert", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public R insert(@RequestBody JSONObject json) {
        log.info("insert-----------");
        try {
            if (StringUtils.isEmpty(json.getString("DATA_TYPE"))) {
                return R.error(String.format("%s 不能为空！", "DATA_TYPE"));
            }
//            else if (json.getIntValue("NUMBER")>0) {
//                return R.error(String.format("%s 不能为空！", "NUMBER"));
//            }
//            else if (json.getIntValue("VOLUME")>0) {
//                return R.error(String.format("%s 不能为空！", "VOLUME"));
//            }
            else if (StringUtils.isEmpty(json.getString("PROCESS"))) {
                return R.error(String.format("%s 不能为空！", "PROCESS"));
            }

            String DATA_TYPE = json.getString("DATA_TYPE");
            Long NUMBER = json.getLong("NUMBER"); Long VOLUME = json.getLong("VOLUME");
            String PROCESS = json.getString("PROCESS");
            Timestamp COLL_TIME = json.getTimestamp("COLL_TIME");
            java.util.Date UP_TIME = new java.util.Date();
            DataInfo dataInfo= new DataInfo();
            dataInfo.setDataType(DATA_TYPE);dataInfo.setNumber(NUMBER);dataInfo.setVolume(VOLUME);
            dataInfo.setProcess(PROCESS);dataInfo.setCollTime(COLL_TIME);dataInfo.setUpTime(UP_TIME);
             int result = dataInfoService.insert(dataInfo);
            return R.ok().put("data", result);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return R.error(e.getMessage());
        }
    }

    @ApiOperation( "查询所有历史数据")
    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
    public R getAll(){
        try {
            List<DataInfo> actions = dataInfoService.getAllActions();
            return R.ok().put("data", actions);
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return R.error(e.getMessage());
        }
    }
    @ApiOperation( "查询IP对应的历史数据")
    @RequestMapping(value = "/getByProc",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public R getByProc(@RequestBody JSONObject json){
        log.info("insert-----------"+json);
        try {
            if (json == null ||StringUtils.isEmpty(json.getString("process"))) {
                return R.error(String.format("%s 不能为空！", "process"));
            }
            String  proc = json.getString("process");
            List<DataInfo> result = dataInfoService.getByProc(proc);
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
