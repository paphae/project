package com.tjetc.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Clock implements Serializable {
    private Integer id;
    private Integer uid;
    private String info;
    private Timestamp ctime;

    public Clock(Integer uid, String info, Timestamp ctime) {
        this.uid = uid;
        this.info = info;
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "Clock{" +
                "id=" + id +
                ", uid=" + uid +
                ", info='" + info + '\'' +
                ", ctime=" + ctime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

    public Clock() {
    }
}
