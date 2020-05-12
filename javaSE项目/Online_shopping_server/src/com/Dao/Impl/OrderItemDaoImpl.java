package com.Dao.Impl;

import java.sql.Connection;
import java.util.List;

import com.Dao.OrderItemDao;
import com.entity.OrderItem;
import com.util.DButil;

public class OrderItemDaoImpl implements OrderItemDao {
	Connection conn = null;
	@Override
	public boolean insert(OrderItem p) {
		conn = DButil.getConnection();
		return DButil.update(conn, "insert into orderitem(pid,uid,number) values(?,?,?)",
				p.getPid(),p.getUid(),p.getNumber());
	}

	@Override
	public boolean delete(int id) {
		conn = DButil.getConnection();
		return DButil.update(conn, "delete from orderitem where id=?", id);
	}

	@Override
	public boolean update(OrderItem p) {
		conn = DButil.getConnection();
		return DButil.update(conn, "update orderitem set number=? where id=?",
				p.getNumber(),p.getId());
	}

	@Override
	public List<OrderItem> selectAll() {
		conn = DButil.getConnection();
		return  DButil.queryList(conn, OrderItem.class, "select * from orderitem", null);
	}

	@Override
	public OrderItem selectById(int id) {
		conn = DButil.getConnection();
		return  DButil.query(conn, OrderItem.class, "select * from orderitem where id=?", id);
	}

}
