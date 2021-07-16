package com.monitor.controller;

import com.monitor.po.AlarmInfo;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.druid.wall.violation.ErrorCode;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.monitor.service.AlarmService;
import com.monitor.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2021/7/15.
 */
@Slf4j
@RestController
@Api(tags = "预警模块")
@RequestMapping(value = "/Alarm")
public class AlarmController {
    @Autowired
    private AlarmService alarmService;

    @ApiOperation( "插入预警数据")
    @RequestMapping(value = "/insert", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public R insert(@RequestBody JSONObject json) {
        try {
            if (json == null ||StringUtils.isEmpty(json.getString("IP"))) {
                return R.error(String.format("%s 不能为空！", "IP"));
            }
            else if (StringUtils.isEmpty(json.getString("ALAM_INFO"))) {
                return R.error(String.format("%s 不能为空！", "ALAM_INFO"));
            }
            else if (StringUtils.isEmpty(json.getString("ALAM_TIME"))) {
                return R.error(String.format("%s 不能为空！", "ALAM_TIME"));
            }
            String ip = json.getString("ip");
            String ALAM_INFO = json.getString("ALAM_INFO");
            Timestamp ALAM_TIME = json.getTimestamp("ALAM_TIME");
            java.util.Date UP_TIME = new java.util.Date();
            AlarmInfo record= new AlarmInfo();
            record.setIp(ip); record.setAlamInfo(ALAM_INFO);record.setAlamTime(ALAM_TIME);
            record.setUpTime(UP_TIME);
            int result = alarmService.insert(record);
            return R.ok().put("data", result);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return R.error(e.getMessage());
        }
    }

    @ApiOperation( "查询所有的预警数据")
    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
    public R getAll(){
        try {
            List<AlarmInfo> actions = alarmService.getAllActions();
            return R.ok().put("data", actions);
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return R.error(e.getMessage());
        }
    }

    @ApiOperation( "查询当日的预警数据")
    @RequestMapping(value = "/getNowAlarm",method = { RequestMethod.GET})
    public R getNowAlarm(){
        try {
            List<AlarmInfo> actions = alarmService.getNowAlarm();
            return R.ok().put("data", actions);
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return R.error(e.getMessage());
        }
    }
    @ApiOperation( "查询当前的预警数据")
    @RequestMapping(value = "/getHourAlarm",method = {RequestMethod.GET})
    public R getHourAlarm(){
        try {
            List<AlarmInfo> actions = alarmService.getHourAlarm();
            return R.ok().put("data", actions);
        }
        catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return R.error(e.getMessage());
        }
    }
}
