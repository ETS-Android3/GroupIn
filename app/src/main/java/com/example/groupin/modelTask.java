package com.example.groupin;

public class modelTask {
    String ttaskid,ttask,tdue,tmember, tstatus;

    public modelTask(String ttaskid, String ttask, String tdue, String tmember, String tstatus) {
        this.ttaskid = ttaskid;
        this.ttask = ttask;
        this.tdue = tdue;
        this.tmember = tmember;
        this.tstatus = tstatus;
    }

    public String getTtaskid() {
        return ttaskid;
    }

    public void setTtaskid(String ttaskid) {
        this.ttaskid = ttaskid;
    }

    public String getTtask() {
        return ttask;
    }

    public void setTtask(String ttask) {
        this.ttask = ttask;
    }

    public String getTdue() {
        return tdue;
    }

    public void setTdue(String tdue) {
        this.tdue = tdue;
    }

    public String getTmember() {
        return tmember;
    }

    public void setTmember(String tmember) {
        this.tmember = tmember;
    }

    public String getTstatus() {
        return tstatus;
    }

    public void setTstatus(String tstatus) {
        this.tstatus = tstatus;
    }
}
