package com.tjetc.service;

import com.tjetc.domain.Emp;

import java.util.List;

public interface EmpService {
    public List<Emp> findAll(Integer mgr);
    public List<Emp> findLike(String key,Integer mgr);
    public List<Emp> findLike(String key);
    public List<Emp> findSubordinates(String key);
    public Emp findByUsername(String ename);
    public Emp findById(Integer empno);
    public boolean insert(String...s);
    public boolean delete(String empno);
    public boolean deleteArray(String[] empnoArray);
    public boolean updateByEmpno(String...s);
}
