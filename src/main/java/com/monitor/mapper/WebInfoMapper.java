package com.monitor.mapper;

import com.monitor.po.ServerState;
import com.monitor.po.WebInfo;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Resource
public interface WebInfoMapper {
    List<WebInfo> getAllActions() throws SQLException;

    int insert(WebInfo res);
    int insertSelective(WebInfo res);
}