package com.jd.dao;

import com.jd.domain.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll();
    Category findById(int id);
}
