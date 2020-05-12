package com.jd.dao.impl;

import com.jd.dao.CategoryDao;
import com.jd.domain.Category;
import com.jd.util.DButil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    Connection conn = null;
    @Override
    public List<Category> findAll() {
        List<Category> categories = null;
        try {
            conn = DButil.getConnection();
            categories = DButil.queryList(conn, Category.class, "select * from category");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category findById(int id) {
        try {
            conn = DButil.getConnection();
            return DButil.query(conn, Category.class, "select * from category where id=?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
