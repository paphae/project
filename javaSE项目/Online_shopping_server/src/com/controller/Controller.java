package com.controller;
//代理的接口，将所有的service都创建到这个类中

import java.util.List;

import com.entity.Category;
import com.entity.Invite;
import com.entity.Order;
import com.entity.OrderItem;
import com.entity.Product;
import com.entity.Review;
import com.entity.User;
import com.service.CategoryService;
import com.service.InviteService;
import com.service.OrderItemService;
import com.service.OrderService;
import com.service.ProductService;
import com.service.ReviewService;
import com.service.UserService;
import com.service.Impl.CategoryServiceImpl;
import com.service.Impl.InviteServiceImpl;
import com.service.Impl.OrderItemServiceImpl;
import com.service.Impl.OrderServiceImpl;
import com.service.Impl.ProductServiceImpl;
import com.service.Impl.ReviewServiceImpl;
import com.service.Impl.UserServiceImpl;

public class Controller implements ShopController{
	private UserService us;
	private InviteService is;
	private CategoryService cs;
	private ProductService ps;
	private OrderItemService ois; 
	private OrderService os;
	private ReviewService rs;
	public Controller() {
		this.us = new UserServiceImpl();
		this.is = new InviteServiceImpl();
		this.cs = new CategoryServiceImpl();
		this.ps = new ProductServiceImpl();
		this.ois = new OrderItemServiceImpl();
		this.os = new OrderServiceImpl();
		this.rs = new ReviewServiceImpl();
	}
	@Override
	public String Useradd(User user) {
		return us.insert(user);
	}
	@Override
	public Invite inviteSelectByCode(int code) {
		return is.selectByCode(code);
	}
	@Override
	public User userSelectByAccountAndPassword(String account, String password) {
		return us.selectByAccountAndPassword(account, password);
	}
	@Override
	public List<Category> categorySelectAll() {
		return cs.selectAll();
	}
	@Override
	public List<Product> productSelectByCid(int cid) {
		return ps.selectByCid(cid);
	}
	@Override
	public Product productSelectByName(String name) {
		return ps.selectByName(name);
	}
	@Override
	public String orderItemAdd(OrderItem o) {
		return ois.insert(o);
	}
	@Override
	public List<OrderItem> orderItemSelectAll() {
		return ois.selectAll();
	}
	@Override
	public String orderAdd(Order o) {
		return os.insert(o);
	}
	@Override
	public List<Order> orderSelectAll() {
		return os.selectAll();
	}
	@Override
	public Order orderSelectById(int id) {
		return os.selectById(id);
	}
	@Override
	public String orderUpdate(Order o) {
		return os.update(o);
	}
	@Override
	public String reviewAdd(Review r) {
		return rs.insert(r);
	}
	@Override
	public String productAdd(Product p) {
		return ps.insert(p);
	}
	@Override
	public String productUpdate(Product p) {
		return ps.update(p);
	}
	@Override
	public List<Product> productSelectAll() {
		return ps.selectAll();
	}
	@Override
	public Category categorySelectById(int id) {
		return cs.selectByCid(id);
	}
	@Override
	public Product productSelectById(int id) {
		return ps.selectById(id);
	}
	@Override
	public String orderItemUpdate(OrderItem o) {
		return ois.update(o);
	}
	@Override
	public List<Order> orderSelectStatus(String status) {
		return os.selectStatus(status);
	}
	@Override
	public List<Order> orderSelectSales() {
		return os.selectSales();
	}
	@Override
	public OrderItem orderItemSelectById(int id) {
		return ois.selectById(id);
	}
	@Override
	public Review reviewSelectByCode(int oid) {
		return rs.selectByCode(oid);
	}
	@Override
	public User userSelectById(int uid) {
		return us.selectById(uid);
	}
	@Override
	public String inviteAdd(Invite i) {
		return is.insert(i);
	}
	@Override
	public List<Invite> inviteSelectAll() {
		return is.selectAll();
	}
}
