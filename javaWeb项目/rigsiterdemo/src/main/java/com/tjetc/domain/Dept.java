package com.tjetc.domain;

import java.io.Serializable;

public class Dept implements Serializable {
    private Integer DEPTNO;
    private String  DNAME;
    private String LOC;

    public Dept() {
    }

    public Dept(String DNAME, String LOC) {
        this.DNAME = DNAME;
        this.LOC = LOC;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "DEPTNO=" + DEPTNO +
                ", DNAME='" + DNAME + '\'' +
                ", LOC='" + LOC + '\'' +
                '}';
    }

    public Integer getDEPTNO() {
        return DEPTNO;
    }

    public void setDEPTNO(Integer DEPTNO) {
        this.DEPTNO = DEPTNO;
    }

    public String getDNAME() {
        return DNAME;
    }

    public void setDNAME(String DNAME) {
        this.DNAME = DNAME;
    }

    public String getLOC() {
        return LOC;
    }

    public void setLOC(String LOC) {
        this.LOC = LOC;
    }
}
