package com.jd.service;

import com.jd.domain.Product;

import java.util.List;

public interface ProductsService {
    List<Product> findAllByName(String name);
}
