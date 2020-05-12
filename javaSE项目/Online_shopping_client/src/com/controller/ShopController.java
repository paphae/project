package com.controller;

import java.util.List;

import com.entity.Category;
import com.entity.Invite;
import com.entity.Order;
import com.entity.OrderItem;
import com.entity.Product;
import com.entity.Review;
import com.entity.User;

public interface ShopController {
	//注册
	String Useradd(User user);
	User userSelectByAccountAndPassword(String account, String password);
	Invite inviteSelectByCode(int code);
	//用户功能
	List<Category> categorySelectAll();
	Category categorySelectById(int id);
	List<Product> productSelectByCid(int cid);
	Product productSelectByName(String name);
	Product productSelectById(int id);	
	String orderItemAdd(OrderItem o);
	String orderItemUpdate(OrderItem o);
	List<OrderItem> orderItemSelectAll();
	String orderAdd(Order o);
	List<Order> orderSelectAll();
	Order orderSelectById(int id);
	String orderUpdate(Order o);
	String reviewAdd(Review r);
	Review reviewSelectByCode(int oid);
	User userSelectById(int uid);
	//商家功能
	String productAdd(Product p);
	String productUpdate(Product p);
	List<Product> productSelectAll(); 
	List<Order> orderSelectStatus(String status);
	List<Order> orderSelectSales();
	OrderItem orderItemSelectById(int id);
	String inviteAdd(Invite i);
	List<Invite> inviteSelectAll();
}
