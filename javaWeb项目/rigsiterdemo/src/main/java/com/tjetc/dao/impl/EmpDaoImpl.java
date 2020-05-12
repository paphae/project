package com.tjetc.dao.impl;

import com.tjetc.dao.EmpDao;
import com.tjetc.domain.Emp;
import com.tjetc.util.DButil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    private Connection conn;

    @Override
    public List<Emp> findSubordinates(String key) {
        List<Emp> emps = new ArrayList<>();
        try {
            conn = DButil.getConnection();
            emps = DButil.queryList(conn, Emp.class, "select * from emp where mgr=?",key);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public Emp findByUsername(String ename) {
        try {
            conn = DButil.getConnection();
            return DButil.query(conn, Emp.class, "select * from emp where ename=?",ename);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Emp> findAll() {
        List<Emp> emps = new ArrayList<>();
        try {
            conn = DButil.getConnection();
            emps = DButil.queryList(conn, Emp.class, "select * from emp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emps;
    }
    @Override
    public List<Emp> findAll(Integer mgr) {
        List<Emp> emps = new ArrayList<>();
        try {
            conn = DButil.getConnection();
            emps = DButil.queryList(conn, Emp.class, "select * from emp where mgr=?",mgr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emps;
    }
    @Override
    public List<Emp> findLike(String key) {
        List<Emp> emps = new ArrayList<>();
        try {
            conn = DButil.getConnection();
            emps = DButil.queryList(conn, Emp.class, "select * from emp where ename like ?","%"+key+"%");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emps;
    }
    @Override
    public List<Emp> findLike(String key,Integer mgr) {
        List<Emp> emps = new ArrayList<>();
        try {
            conn = DButil.getConnection();
            emps = DButil.queryList(conn, Emp.class, "select * from emp where ename like ? and mgr=?","%"+key+"%",mgr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emps;
    }
    @Override
    public Emp findById(Integer empno) {
        Emp emp = null;
        try {
            conn = DButil.getConnection();
            emp = DButil.query(conn, Emp.class,
                    "select * from emp where empno=?",empno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public boolean insert(Emp e) {
        try {
            conn = DButil.getConnection();
            int i = DButil.update(conn, "insert into emp value(?,?,?,?,?,?,?,?)",
                    e.getEMPNO(), e.getENAME(), e.getJOB(), e.getMGR(),
                    e.getHIREDATE(), e.getSAL(), e.getCOMM(), e.getDEPTNO());
            if(i>0)return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteByEmpno(int empno) {
        try {
            conn = DButil.getConnection();
            int i = DButil.update(conn, "delete from emp where EMPNO=?",
                   empno);
            if(i>0)return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteArray(String[] empnoArray) {
        String sql = "delete from emp where empno in (";
        for (String s : empnoArray) {
            sql+=s+",";
        }
        sql = sql.substring(0,sql.length()-1);
        sql+=")";
        try {
            conn = DButil.getConnection();
            int i = DButil.update(conn, sql);
            if(i>0)return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean updateByEmpno(Emp e) {
        try {
            conn = DButil.getConnection();
            int i = DButil.update(conn, "update emp set ENAME=?," +
                            "JOB=?,MGR=?,HIREDATE=?,SAL=?,COMM=?,DEPTNO=? where empno=?",
                     e.getENAME(), e.getJOB(), e.getMGR(),
                    e.getHIREDATE(), e.getSAL(), e.getCOMM(), e.getDEPTNO(),e.getEMPNO());
            if(i>0)return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
