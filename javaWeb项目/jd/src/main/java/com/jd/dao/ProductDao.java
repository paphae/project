package com.jd.dao;

import com.jd.domain.Product;

public interface ProductDao {
    Product findById(int id);
}
