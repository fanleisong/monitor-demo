package com.monitor.service.impl;

import com.monitor.mapper.AlarmInfoMapper;
import com.monitor.po.AlarmInfo;
import com.monitor.service.AlarmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2021/7/15.
 */
@Service
@Slf4j
public class AlarmServiceImpl implements AlarmService {

   @Autowired(required=true)
   AlarmInfoMapper alarmInfoMapper;

    @Override
    public int insert(AlarmInfo record) {
        return alarmInfoMapper.insert(record);
    }
    @Override
    public int insertSelective(AlarmInfo record) {
        return alarmInfoMapper.insertSelective(record);
    }
    @Override
    public List<AlarmInfo> getAllActions() throws SQLException {
        return alarmInfoMapper.getAllActions();
    }

    @Override
    public List<AlarmInfo> getNowAlarm() throws SQLException {
        return alarmInfoMapper.getNowAlarm();
    }

    @Override
    public List<AlarmInfo> getHourAlarm() throws SQLException {
        return alarmInfoMapper.getHourAlarm();
    }
}
