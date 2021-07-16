package com.monitor.mapper;

import com.monitor.po.AlarmInfo;
import org.mapstruct.Mapper;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;


@Resource
public interface AlarmInfoMapper {
    int insert(AlarmInfo record);

    int insertSelective(AlarmInfo record);

    List<AlarmInfo> getAllActions() throws SQLException;

    List<AlarmInfo> getNowAlarm()throws SQLException;

    List<AlarmInfo> getHourAlarm() throws SQLException;
}