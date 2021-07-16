package com.monitor.service.impl;

import com.monitor.mapper.AlarmInfoMapper;
import com.monitor.mapper.ResourcesInfoMapper;
import com.monitor.po.AlarmInfo;
import com.monitor.po.ResourcesInfo;
import com.monitor.service.AlarmService;
import com.monitor.service.ResourceService;
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
public class ResourceServiceImpl implements ResourceService {


    @Autowired(required=true)
    ResourcesInfoMapper resourcesInfoMapper;


    @Override
    public List<ResourcesInfo> getAllActions() throws SQLException {
        return resourcesInfoMapper.getAllActions();
    }

    @Override
    public int insert(ResourcesInfo res) {
        return resourcesInfoMapper.insert(res);
    }

    @Override
    public int insertSelective(ResourcesInfo res) {
        return resourcesInfoMapper.insertSelective(res);
    }

    @Override
    public List<ResourcesInfo> getInfoByIP(String ip) throws SQLException {
        return resourcesInfoMapper.getInfoByIP(ip);
    }
}
