package com.monitor.mapper;

import com.monitor.po.ResourcesInfo;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Resource
public interface ResourcesInfoMapper {
    List<ResourcesInfo> getAllActions() throws SQLException;

    int insert(ResourcesInfo res);
    int insertSelective(ResourcesInfo res);

    List<ResourcesInfo> getInfoByIP(String ip) throws SQLException;
}