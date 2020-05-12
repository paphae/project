package com.Dao;

import java.util.List;

import com.entity.Category;
import com.entity.Product;

public interface CategoryDao {
	boolean insert(Category p);
	boolean delete(int id);
	boolean update(Category p);
	List<Category> selectAll();
	List<Product> selectById(int id);
	List<Product> selectByName(String name);
	Category selectByCid(int cid);
}
