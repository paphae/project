package com.jd.dao.impl;

import com.jd.dao.ProductsDao;
import com.jd.domain.Product;
import com.jd.util.DButil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductsDaoImpl implements ProductsDao {
    Connection conn = null;
    @Override
    public List<Product> findAllByName(String name) {
        List<Product> products = null;
        try {
            conn = DButil.getConnection();
            products = DButil.queryList(conn, Product.class,
                    "select p.* from product p ,category c where p.cid=c.id and c.`name`=?",name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
