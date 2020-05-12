package com.Dao.Impl;

import java.sql.Connection;
import java.util.List;

import com.Dao.CategoryDao;
import com.entity.Category;
import com.entity.Product;
import com.util.DButil;

public class CategoryDaoImpl implements CategoryDao {
	Connection conn = null;
	@Override
	public boolean insert(Category p) {
		conn = DButil.getConnection();
		return DButil.update(conn, "insert into category(name) values(?)",
				p.getName());

	}

	@Override
	public boolean delete(int id) {
		conn = DButil.getConnection();
		return DButil.update(conn, "delete from category where id=?", id);
	}

	@Override
	public boolean update(Category p) {
		conn = DButil.getConnection();
		return DButil.update(conn, "update category set name=? where id=?",
				p.getName(),p.getId());
	}

	@Override
	public List<Category> selectAll() {
		conn = DButil.getConnection();
		return  DButil.queryList(conn, Category.class, "select * from category", null);
	}

	@Override
	public List<Product> selectById(int id) {
		conn = DButil.getConnection();
		return DButil.queryList(conn, Product.class, "SELECT p.* FROM product p ,category c where p.cid=c.id and c.id=?", id);
	}

	@Override
	public List<Product> selectByName(String name) {
		conn = DButil.getConnection();
		return DButil.queryList(conn, Product.class, "SELECT p.* FROM product p ,category c where p.cid=c.id and c.name=?", name);
	}

	@Override
	public Category selectByCid(int cid) {
		conn = DButil.getConnection();
		return DButil.query(conn, Category.class, "SELECT * from category where id=?", cid);

	}

}
