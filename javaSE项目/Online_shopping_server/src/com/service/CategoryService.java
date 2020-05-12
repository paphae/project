package com.service;

import java.util.List;

import com.entity.Category;
import com.entity.Product;

public interface CategoryService {
	String insert(Category p);
	String delete(int id);
	String update(Category p);
	List<Category> selectAll();
	List<Product> selectById(int id);
	List<Product> selectByName(String name);
	Category selectByCid(int cid);
}
