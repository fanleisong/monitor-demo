package com.monitor.service;

import com.monitor.po.ResourcesInfo;
import com.monitor.po.ServerState;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2021/7/15.
 */

public interface ServerStateService {

    List<ServerState> getAllActions() throws SQLException;

    int insert(ServerState res);
    int insertSelective(ServerState res);

    List<ServerState> getInfoByIP(String ip) throws SQLException;

}
