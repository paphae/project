package com.service;

import java.util.List;

import com.entity.Order;

public interface OrderService {
	String insert(Order p);
	String delete(int id);
	String update(Order p);
	List<Order> selectAll();
	Order selectById(int id);
	Order selectByCode(int oid);
	List<Order> selectStatus(String status);
	List<Order> selectSales();
}
