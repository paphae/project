package com.Dao;

import java.util.List;

import com.entity.Product;

public interface ProductDao {
	boolean insert(Product p);
	boolean delete(int id);
	boolean update(Product p);
	List<Product> selectAll();
	Product selectById(int id);
	Product selectByName(String name);
	List<Product> selectByCid(int cid);
}
