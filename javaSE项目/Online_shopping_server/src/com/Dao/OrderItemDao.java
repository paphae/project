package com.Dao;

import java.util.List;

import com.entity.OrderItem;


public interface OrderItemDao {
	boolean insert(OrderItem p);
	boolean delete(int id);
	boolean update(OrderItem p);
	List<OrderItem> selectAll();
	OrderItem selectById(int id);
}
