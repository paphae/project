package com.jd.domain;

import java.io.Serializable;

public class Cart implements Serializable {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Integer number;

    public Cart() {
    }

    public Cart(Integer uid, Integer pid, Integer number) {
        this.uid = uid;
        this.pid = pid;
        this.number = number;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "{" +
                "cid:" + cid +
                ", uid:" + uid +
                ", pid:" + pid +
                ", number:" + number +
                '}';
    }
}
