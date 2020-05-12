package com.service;

import java.util.List;

import com.entity.OrderItem;

public interface OrderItemService {
	String insert(OrderItem p);
	String delete(int id);
	String update(OrderItem p);
	List<OrderItem> selectAll();
	OrderItem selectById(int id);
}
