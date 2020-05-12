package com.tjetc.service.impl;

import com.tjetc.dao.DeptDao;
import com.tjetc.dao.impl.DeptDaoImpl;
import com.tjetc.domain.Dept;
import com.tjetc.service.DeptService;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    DeptDao dd = new DeptDaoImpl();
    @Override
    public List<Dept> findAll() {
        return dd.findAll();
    }
}
