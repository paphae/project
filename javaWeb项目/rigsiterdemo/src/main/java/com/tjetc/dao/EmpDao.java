package com.tjetc.dao;

import com.tjetc.domain.Emp;

import java.util.List;

public interface EmpDao {
    public List<Emp> findAll();
    public List<Emp> findAll(Integer mgr);
    public List<Emp> findLike(String key);
    public List<Emp> findLike(String key,Integer mgr);
    public Emp findByUsername(String ename);
    public List<Emp> findSubordinates(String key);
    public Emp findById(Integer empno);
    public boolean insert(Emp e);
    public boolean deleteByEmpno(int empno);
    public boolean deleteArray(String[] empnoArray);
    public boolean updateByEmpno(Emp e);
}
