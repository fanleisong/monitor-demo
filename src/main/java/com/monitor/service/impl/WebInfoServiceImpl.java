package com.monitor.service.impl;

import com.monitor.mapper.ServerStateMapper;
import com.monitor.mapper.WebInfoMapper;
import com.monitor.po.ServerState;
import com.monitor.po.WebInfo;
import com.monitor.service.ServerStateService;
import com.monitor.service.WebInfoService;
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
public class WebInfoServiceImpl implements WebInfoService {

    @Autowired(required=true)
    WebInfoMapper webInfoMapper;


    @Override
    public List<WebInfo> getAllActions() throws SQLException {
        return webInfoMapper.getAllActions();
    }

    @Override
    public int insert(WebInfo web) {
        return webInfoMapper.insert(web);
    }

    @Override
    public int insertSelective(WebInfo web) {
        return webInfoMapper.insertSelective(web);
    }
}
