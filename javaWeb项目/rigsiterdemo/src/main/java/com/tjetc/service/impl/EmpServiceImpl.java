package com.tjetc.service.impl;

import com.tjetc.dao.EmpDao;
import com.tjetc.dao.impl.EmpDaoImpl;
import com.tjetc.domain.Emp;
import com.tjetc.service.EmpService;

import java.sql.Date;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    EmpDao edao = new EmpDaoImpl();
    @Override
    public List<Emp> findAll(Integer mgr) {
        if(mgr==1){
            return edao.findAll();
        }else {
            return edao.findAll(mgr);
        }
    }

    @Override
    public List<Emp> findLike(String key) {
        if (key==null || key.equals("")){
            return edao.findAll();
        }else {
            return edao.findLike(key);
        }
    }

    @Override
    public List<Emp> findLike(String key, Integer mgr) {
        if (mgr==1){
            return edao.findLike(key);
        }else {
            return edao.findLike(key,mgr);
        }
    }

    @Override
    public List<Emp> findSubordinates(String key) {
        return edao.findSubordinates(key);
    }

    @Override
    public Emp findByUsername(String ename) {
        return edao.findByUsername(ename);
    }

    @Override
    public boolean insert(String...s) {
        Integer EMPNO = 0;
        String ENAME = null;
        String JOB = null;
        Integer MGR = null;
        //
        Date HIREDATE = null;
        Double SAL = null;
        Double COMM = null;
        Integer DEPTNO = null;
        if(!s[0].equals(""))EMPNO=Integer.parseInt(s[0]);
        ENAME=s[1];
        JOB=s[2];
        if(!s[3].equals(""))MGR=Integer.parseInt(s[3]);
        if(!s[4].equals(""))HIREDATE=Date.valueOf(s[4]);
        if(!s[5].equals(""))SAL=Double.parseDouble(s[5]);
        if(!s[6].equals(""))COMM=Double.parseDouble(s[6]);
        if(!s[7].equals(""))DEPTNO=Integer.parseInt(s[7]);
        return edao.insert(new Emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO));
    }

    @Override
    public boolean delete(String empno) {
        if(empno.equals(""))return false;
        return edao.deleteByEmpno(Integer.parseInt(empno));
    }

    @Override
    public boolean deleteArray(String[] empnoArray) {
        return edao.deleteArray(empnoArray);
    }

    @Override
    public Emp findById(Integer empno) {
        return edao.findById(empno);
    }

    @Override
    public boolean updateByEmpno(String...s) {
        Integer EMPNO = 0;
        String ENAME = null;
        String JOB = null;
        Integer MGR = null;
        //
        Date HIREDATE = null;
        Double SAL = null;
        Double COMM = null;
        Integer DEPTNO = null;
        if(!s[0].equals(""))EMPNO=Integer.parseInt(s[0]);
        ENAME=s[1];
        JOB=s[2];
        if(!s[3].equals(""))MGR=Integer.parseInt(s[3]);
        if(!s[4].equals(""))HIREDATE=Date.valueOf(s[4]);
        if(!s[5].equals(""))SAL=Double.parseDouble(s[5]);
        if(!(s[6].equals("")||s[6].equals("null")))COMM=Double.parseDouble(s[6]);
        if(!s[7].equals(""))DEPTNO=Integer.parseInt(s[7]);
        return edao.updateByEmpno(new Emp(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO));

    }
}
