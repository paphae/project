package com.service;

import java.util.List;

import com.entity.Product;

public interface ProductService {
	String insert(Product p);
	String delete(int id);
	String update(Product p);
	List<Product> selectAll();
	Product selectById(int id);
	Product selectByName(String name);
	List<Product> selectByCid(int cid);
}
