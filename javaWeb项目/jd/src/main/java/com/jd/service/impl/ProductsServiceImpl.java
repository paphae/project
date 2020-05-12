package com.jd.service.impl;

import com.jd.dao.ProductsDao;
import com.jd.dao.impl.ProductsDaoImpl;
import com.jd.domain.Product;
import com.jd.service.ProductsService;

import java.util.List;

public class ProductsServiceImpl implements ProductsService {
    ProductsDao pd = new ProductsDaoImpl();
    @Override
    public List<Product> findAllByName(String name) {
        return pd.findAllByName(name);
    }
}
