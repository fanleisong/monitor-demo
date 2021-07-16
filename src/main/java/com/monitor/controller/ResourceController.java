package com.monitor.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.monitor.po.AlarmInfo;
import com.monitor.po.ResourcesInfo;
import com.monitor.service.AlarmService;
import com.monitor.service.ResourceService;
import com.monitor.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2021/7/15.
 */
@Slf4j
@RestController
@Api(tags = "资源信息")
@RequestMapping(value = "/Resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @ApiOperation( "插入资源信息")
    @RequestMapping(value = "/insert", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public R insert(@RequestBody JSONObject json) {
        log.info("insert-----------");
        try {
            if (json == null ||StringUtils.isEmpty(json.getString("IP"))) {
                return R.error(String.format("%s 不能为空！", "IP"));
            }
            else if (StringUtils.isEmpty(json.getString("COLL_TIME"))) {
                return R.error(String.format("%s 不能为空！", "COLL_TIME"));
            }
            String ip = json.getString("ip");
            Float CPU_RATE = json.getFloatValue("CPU_RATE");
            Float MEM_RATE = json.getFloatValue("MEM_RATE");
            Float DISK_RATE = json.getFloatValue("DISK_RATE");
            Timestamp COLL_TIME = json.getTimestamp("COLL_TIME");

            java.util.Date UP_TIME = new java.util.Date();
            ResourcesInfo res= new ResourcesInfo();
            res.setIp(ip); res.setCpuRate(CPU_RATE);res.setMemRate(MEM_RATE);res.setDiskRate(DISK_RATE);
            res.setUpTime(UP_TIME);res.setCollTime(COLL_TIME);
            int result = resourceService.insert(res);
            return R.ok().put("data", result);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return R.error(e.getMessage());
        }
    }

    @ApiOperation( "查询所有资源信息数据")
    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
    public R getAll(){
        try {
            List<ResourcesInfo> actions = resourceService.getAllActions();
            return R.ok().put("data", actions);
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return R.error(e.getMessage());
        }
    }
    @ApiOperation( "查询IP对应的资源信息")
    @RequestMapping(value = "/getInfoByIP",method = {RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public R getInfoByIP(@RequestBody JSONObject json){
        log.info("insert-----------"+json);
        try {
            if (json == null ||StringUtils.isEmpty(json.getString("ip"))) {
                return R.error(String.format("%s 不能为空！", "ip"));
            }
            String  ip = json.getString("ip");
            List<ResourcesInfo> result = resourceService.getInfoByIP(ip);
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
