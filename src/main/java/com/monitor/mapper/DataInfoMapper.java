package com.monitor.mapper;

import com.monitor.po.DataInfo;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
@Resource
public interface DataInfoMapper {

    List<DataInfo> getAllActions() throws SQLException;

    int insert(DataInfo res);
    int insertSelective(DataInfo res);

    List<DataInfo> getByProc(String proc) throws SQLException;
}