package com.tjetc.dao.impl;

import com.tjetc.dao.DeptDao;
import com.tjetc.domain.Dept;
import com.tjetc.util.DButil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    Connection conn = null;
    @Override
    public List<Dept> findAll() {
        List<Dept> depts = new ArrayList<>();
        try {
            conn = DButil.getConnection();
            depts = DButil.queryList(conn, Dept.class, "select * from dept");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depts;
    }
}
