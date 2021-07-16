package com.monitor.service;

import com.monitor.po.ServerState;
import com.monitor.po.WebInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2021/7/15.
 */

public interface WebInfoService {

    List<WebInfo> getAllActions() throws SQLException;

    int insert(WebInfo web);
    int insertSelective(WebInfo web);

}
