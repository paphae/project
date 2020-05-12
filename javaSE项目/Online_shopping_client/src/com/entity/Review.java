package com.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Review implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 123456L;
	private Integer id;
	private String content;
	private Integer uid;
	private Integer oid;	
	private User user;
	private Product product;
	private Timestamp createDate;
	public Review(String content, Integer uid, Integer oid, Timestamp createDate) {
		super();
		this.content = content;
		this.uid = uid;
		this.oid = oid;
		this.createDate = createDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Review() {
		super();
	}

	
	
}
