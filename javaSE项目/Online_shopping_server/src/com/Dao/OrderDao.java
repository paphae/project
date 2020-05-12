package com.Dao;

import java.util.List;

import com.entity.Order;

public interface OrderDao {
	boolean insert(Order p);
	boolean delete(int id);
	boolean update(Order p);
	List<Order> selectAll();
	Order selectById(int id);
	Order selectByCode(int oid);
	List<Order> selectStatus(String status);
	List<Order> selectSales();
}
