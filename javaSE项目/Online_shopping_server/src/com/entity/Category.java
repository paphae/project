package com.entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 123456L;
	private Integer id;
	private String name;
	List<Product> products;
	
	public Category() {
		super();
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + "]";
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
