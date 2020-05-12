package com.tjetc.domain;

import java.io.Serializable;
import java.sql.Date;

public class Emp implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer EMPNO;
    private String ENAME;
    private String JOB;
    private Integer MGR;
    //
    private Date HIREDATE;
    private Double SAL;
    private Double COMM;
    private Integer DEPTNO;

    public Emp() {
    }

    public Emp(Integer EMPNO, String ENAME, String JOB, Integer MGR, Date HIREDATE, Double SAL, Double COMM, Integer DEPTNO) {
        this.EMPNO = EMPNO;
        this.ENAME = ENAME;
        this.JOB = JOB;
        this.MGR = MGR;
        this.HIREDATE = HIREDATE;
        this.SAL = SAL;
        this.COMM = COMM;
        this.DEPTNO = DEPTNO;
    }

    public Integer getEMPNO() {
        return EMPNO;
    }

    public void setEMPNO(Integer EMPNO) {
        this.EMPNO = EMPNO;
    }

    public String getENAME() {
        return ENAME;
    }

    public void setENAME(String ENAME) {
        this.ENAME = ENAME;
    }

    public String getJOB() {
        return JOB;
    }

    public void setJOB(String JOB) {
        this.JOB = JOB;
    }

    public Integer getMGR() {
        return MGR;
    }

    public void setMGR(Integer MGR) {
        this.MGR = MGR;
    }

    public Date getHIREDATE() {
        return HIREDATE;
    }

    public void setHIREDATE(Date HIREDATE) {
        this.HIREDATE = HIREDATE;
    }

    public Double getSAL() {
        return SAL;
    }

    public void setSAL(Double SAL) {
        this.SAL = SAL;
    }

    public Double getCOMM() {
        return COMM;
    }

    public void setCOMM(Double COMM) {
        this.COMM = COMM;
    }

    public Integer getDEPTNO() {
        return DEPTNO;
    }

    public void setDEPTNO(Integer DEPTNO) {
        this.DEPTNO = DEPTNO;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "EMPNO=" + EMPNO +
                ", ENAME='" + ENAME + '\'' +
                ", JOB='" + JOB + '\'' +
                ", MGR=" + MGR +
                ", HIREDATE=" + HIREDATE +
                ", SAL=" + SAL +
                ", COMM=" + COMM +
                ", DEPTNO=" + DEPTNO +
                '}';
    }
}