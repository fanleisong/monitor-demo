package com.monitor.po;

import java.util.Date;

public class AlarmInfo {
    private Long id;

    private String ip;

    private String alamInfo;

    private Date alamTime;

    private Date upTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getAlamInfo() {
        return alamInfo;
    }

    public void setAlamInfo(String alamInfo) {
        this.alamInfo = alamInfo == null ? null : alamInfo.trim();
    }

    public Date getAlamTime() {
        return alamTime;
    }

    public void setAlamTime(Date alamTime) {
        this.alamTime = alamTime;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }
}