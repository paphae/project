package com.jd.service;

import com.jd.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(int id);
}
