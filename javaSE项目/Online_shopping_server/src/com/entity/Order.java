package com.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import java.util.List;

public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 123456L;
	private Integer id;
	private Integer oid;
	private String address;
	private String receiver;
	private String mobile;
	private Timestamp createDate;
	private Timestamp deliveryDate;
	private Timestamp confirmDate;
	private String status;
	private User user;
	private List<OrderItem> orderItems;
	private float total;
	
	public Order(Integer oid, String address, String receiver, String mobile, 
			Timestamp createDate, Timestamp deliveryDate, Timestamp confirmDate, String status) {
		super();
		this.oid = oid;
		this.address = address;
		this.receiver = receiver;
		this.mobile = mobile;
		this.createDate = createDate;
		this.deliveryDate = deliveryDate;
		this.confirmDate = confirmDate;
		this.status = status;
	}

	public Order() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Timestamp getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Timestamp confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", oid=" + oid + ", address=" + address  + ", receiver=" + receiver
				+ ", mobile=" + mobile  + ", createDate=" + createDate
				+ ", deliveryDate=" + deliveryDate + ", confirmDate=" + confirmDate + ", status=" + status + ", user="
				+ user + ", orderItems=" + orderItems + ", total=" + total + "]";
	}
	
	
}
