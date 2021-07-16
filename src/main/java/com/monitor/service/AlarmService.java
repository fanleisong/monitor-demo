package com.monitor.service;

import com.monitor.mapper.AlarmInfoMapper;
import com.monitor.po.AlarmInfo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2021/7/15.
 */

public interface AlarmService  {

     int insert(AlarmInfo record);

      int insertSelective(AlarmInfo record);

    List<AlarmInfo> getAllActions() throws SQLException;

    List<AlarmInfo> getNowAlarm() throws SQLException;

    List<AlarmInfo> getHourAlarm() throws SQLException;
}
