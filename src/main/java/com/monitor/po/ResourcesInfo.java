package com.monitor.po;

import java.util.Date;

public class ResourcesInfo {
    private String ip;

    private Float cpuRate;

    private Float memRate;

    private Float diskRate;

    private Date collTime;

    private Date upTime;

    private Long id;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Float getCpuRate() {
        return cpuRate;
    }

    public void setCpuRate(Float cpuRate) {
        this.cpuRate = cpuRate;
    }

    public Float getMemRate() {
        return memRate;
    }

    public void setMemRate(Float memRate) {
        this.memRate = memRate;
    }

    public Float getDiskRate() {
        return diskRate;
    }

    public void setDiskRate(Float diskRate) {
        this.diskRate = diskRate;
    }

    public Date getCollTime() {
        return collTime;
    }

    public void setCollTime(Date collTime) {
        this.collTime = collTime;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}