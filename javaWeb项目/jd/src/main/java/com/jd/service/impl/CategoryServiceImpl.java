package com.jd.service.impl;

import com.jd.dao.CategoryDao;
import com.jd.dao.impl.CategoryDaoImpl;
import com.jd.domain.Category;
import com.jd.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao cd = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        return cd.findAll();
    }

    @Override
    public Category findById(int id) {
        return cd.findById(id);
    }
}
