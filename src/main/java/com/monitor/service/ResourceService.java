package com.monitor.service;

import com.monitor.po.AlarmInfo;
import com.monitor.po.ResourcesInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2021/7/15.
 */

public interface ResourceService  {

    List<ResourcesInfo> getAllActions() throws SQLException;

    int insert(ResourcesInfo res);
    int insertSelective(ResourcesInfo res);

    List<ResourcesInfo> getInfoByIP(String ip) throws SQLException;

}
