package com.Dao.Impl;

import java.sql.Connection;
import java.util.List;

import com.Dao.ProductDao;
import com.entity.Product;
import com.util.DButil;

public class ProductDaoImpl implements ProductDao {
	Connection conn = null;
	@Override
	public boolean insert(Product p) {
		conn = DButil.getConnection();
		return DButil.update(conn, "insert into product values(0,?,?,?,?,?,?)",
				p.getName(),p.getOrignalPrice(),p.getPromotePrice(),
				p.getStock(),p.getCid(),p.getCreateDate());
	}

	@Override
	public boolean delete(int id) {
		conn = DButil.getConnection();
		return DButil.update(conn, "delete from product where id=?", id);
	}

	@Override
	public boolean update(Product p) {
		conn = DButil.getConnection();
		return DButil.update(conn, "update product set name=?,orignalPrice=?,promotePrice=?"
				+ ",stock=?,cid=?,createdate=? where id=?",
				p.getName(),p.getOrignalPrice(),p.getPromotePrice(),
				p.getStock(),p.getCid(),p.getCreateDate(),p.getId());
	}

	@Override
	public List<Product> selectAll() {
		conn = DButil.getConnection();
		return  DButil.queryList(conn, Product.class, "select * from product", null);
	}

	@Override
	public Product selectById(int id) {
		conn = DButil.getConnection();
		return DButil.query(conn, Product.class, "select * from product where id=?", id);
	}

	@Override
	public Product selectByName(String name) {
		conn = DButil.getConnection();
		return DButil.query(conn, Product.class, "select * from product where name=?", name);
	}

	@Override
	public List<Product> selectByCid(int cid) {
		conn = DButil.getConnection();
		return  DButil.queryList(conn, Product.class, "select * from product where cid=?", cid);
	}

}
