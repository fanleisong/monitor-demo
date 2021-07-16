package com.monitor.service.impl;

import com.monitor.mapper.DataInfoMapper;
import com.monitor.mapper.ServerStateMapper;
import com.monitor.po.DataInfo;
import com.monitor.po.ServerState;
import com.monitor.service.DataInfoService;
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
public class DataInfoServiceImpl implements DataInfoService {

    @Autowired(required=true)
    DataInfoMapper dataInfoMapper;


    @Override
    public List<DataInfo> getAllActions() throws SQLException {
        return dataInfoMapper.getAllActions();
    }

    @Override
    public int insert(DataInfo dat) {
        return dataInfoMapper.insert(dat);
    }

    @Override
    public int insertSelective(DataInfo dat) {
        return dataInfoMapper.insert(dat);
    }

    @Override
    public List<DataInfo> getByProc(String proc) throws SQLException {
        return dataInfoMapper.getByProc(proc);
    }


}
