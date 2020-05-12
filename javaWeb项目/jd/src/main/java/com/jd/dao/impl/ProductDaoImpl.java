package com.jd.dao.impl;

import com.jd.dao.ProductDao;
import com.jd.domain.Product;
import com.jd.util.DButil;

import java.sql.Connection;
import java.sql.SQLException;

public class ProductDaoImpl implements ProductDao {
    Connection conn = null;
    @Override
    public Product findById(int id) {
        try {
            conn = DButil.getConnection();
            return DButil.query(conn,Product.class,"select * from product where id =?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
