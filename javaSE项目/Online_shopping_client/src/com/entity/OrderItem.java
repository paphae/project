package com.entity;

import java.io.Serializable;

public class OrderItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 123456L;
	private Product product;
	private Order order;
	private User user;
	private Integer id;
	private Integer pid;
	private Integer uid;
	private Integer number;
	public OrderItem(Integer pid, Integer uid, Integer number) {
		super();
		this.pid = pid;
		this.uid = uid;
		this.number = number;
	}
	public OrderItem() {
		super();
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "OrderItem [product=" + product + ", order=" + order + ", user=" + user + ", id=" + id + ", pid=" + pid
				+ ", uid=" + uid + ", number=" + number + "]";
	}
	
}
