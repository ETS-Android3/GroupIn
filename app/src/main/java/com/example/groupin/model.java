package com.example.groupin;

public class model {

    String pid,pname, pdue,pstatus;

    public model(String pid,String pname, String pdue, String pstatus) {
        this.pid = pid;
        this.pname = pname;
        this.pdue = pdue;
        this.pstatus = pstatus;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdue() {
        return pdue;
    }

    public void setPdue(String pdue) {
        this.pdue = pdue;
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }
}
