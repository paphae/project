package com.jd.dao;

import com.jd.domain.Product;

import java.util.List;

public interface ProductsDao {
    List<Product> findAllByName(String name);
}
