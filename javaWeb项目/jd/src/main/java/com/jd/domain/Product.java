package com.jd.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Product implements Serializable {
    private Integer id;
    private String name;
    private Double orignalPrice;
    private Double promotePrice;
    private Integer stock;
    private Integer cid;
    private Timestamp createDate;

    public Product() {
    }

    public Product(String name, Double orignalPrice, Double promotePrice, Integer stock, Timestamp createDate) {
        this.name = name;
        this.orignalPrice = orignalPrice;
        this.promotePrice = promotePrice;
        this.stock = stock;
        this.createDate = createDate;
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

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orignalPrice=" + orignalPrice +
                ", promotePrice=" + promotePrice +
                ", stock=" + stock +
                ", cid=" + cid +
                ", createDate=" + createDate +
                '}';
    }
}
