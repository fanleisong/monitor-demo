package com.monitor.service;

import com.monitor.po.DataInfo;
import com.monitor.po.ServerState;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2021/7/15.
 */

public interface DataInfoService {

    List<DataInfo> getAllActions() throws SQLException;

    int insert(DataInfo res);
    int insertSelective(DataInfo res);

    List<DataInfo> getByProc(String proc) throws SQLException;

}
