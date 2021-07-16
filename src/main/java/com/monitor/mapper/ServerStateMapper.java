package com.monitor.mapper;

import com.monitor.po.ResourcesInfo;
import com.monitor.po.ServerState;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
@Resource
public interface ServerStateMapper {
    List<ServerState> getAllActions() throws SQLException;

    int insert(ServerState res);
    int insertSelective(ServerState res);

    List<ServerState> getInfoByIP(String ip) throws SQLException;
}