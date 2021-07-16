package com.monitor.po;

import java.util.Date;

public class ServerState {
    private String program;

    private String funDes;

    private String runState;

    private Date upTime;
    private Date collTime;

    private String details;

    private String ip;

    private String process;

    private Long id;

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program == null ? null : program.trim();
    }

    public String getFunDes() {
        return funDes;
    }

    public void setFunDes(String funDes) {
        this.funDes = funDes == null ? null : funDes.trim();
    }

    public String getRunState() {
        return runState;
    }

    public void setRunState(String runState) {
        this.runState = runState == null ? null : runState.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process == null ? null : process.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}