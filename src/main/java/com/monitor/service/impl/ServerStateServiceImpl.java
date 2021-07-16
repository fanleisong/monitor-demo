package com.monitor.service.impl;

import com.monitor.mapper.ResourcesInfoMapper;
import com.monitor.mapper.ServerStateMapper;
import com.monitor.po.ResourcesInfo;
import com.monitor.po.ServerState;
import com.monitor.service.ResourceService;
import com.monitor.service.ServerStateService;
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
public class ServerStateServiceImpl implements ServerStateService {

    @Autowired(required=true)
    ServerStateMapper serverStateMapper;
    @Override
    public List<ServerState> getAllActions() throws SQLException {
        return serverStateMapper.getAllActions();
    }

    @Override
    public int insert(ServerState ser) {
        return serverStateMapper.insert(ser);
    }

    @Override
    public int insertSelective(ServerState ser) {
        return serverStateMapper.insert(ser);
    }

    @Override
    public List<ServerState> getInfoByIP(String ip) throws SQLException {
        return serverStateMapper.getInfoByIP(ip);
    }



}
