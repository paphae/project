package com.entity;

import java.io.Serializable;
import java.sql.Timestamp;



public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 123456L;
	private Integer id;
	private String name;
	private Double orignalPrice;
	private Double promotePrice;
	private Integer stock;
	private Category category;
	private Integer cid;
	private Timestamp createDate;
	private Integer reviewCount;
	private Integer saleCount;
	public Product(String name, Double orignalPrice, Double promotePrice, Integer stock, Integer cid,
			Timestamp createDate) {
		super();
		this.name = name;
		this.orignalPrice = orignalPrice;
		this.promotePrice = promotePrice;
		this.stock = stock;
		this.cid = cid;
		this.createDate = createDate;
	}
	public Product() {
		super();
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
	public Double getOrignalPrice() {
		return orignalPrice;
	}
	public void setOrignalPrice(Double orignalPrice) {
		this.orignalPrice = orignalPrice;
	}
	public Double getPromotePrice() {
		return promotePrice;
	}
	public void setPromotePrice(Double promotePrice) {
		this.promotePrice = promotePrice;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Integer getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}
	public Integer getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", orignalPrice=" + orignalPrice + ", promotePrice="
				+ promotePrice + ", stock=" + stock + ", category=" + category + ", cid=" + cid + ", createDate="
				+ createDate + ", reviewCount=" + reviewCount + ", saleCount=" + saleCount + "]";
	}
	
	

	
}
