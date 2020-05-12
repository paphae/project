package com.jd.service.impl;

import com.jd.dao.ProductDao;
import com.jd.dao.impl.ProductDaoImpl;
import com.jd.domain.Product;
import com.jd.service.ProductService;

public class ProductServiceImpl implements ProductService {
    ProductDao pd = new ProductDaoImpl();
    @Override
    public Product findById(int id) {
        return pd.findById(id);
    }
}
