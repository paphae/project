package com.Dao.Impl;

import java.sql.Connection;
import java.util.List;

import com.Dao.OrderDao;
import com.entity.Order;
import com.entity.Product;
import com.util.DButil;

public class OrderDaoImpl implements OrderDao{
	Connection conn = null;
	@Override
	public boolean insert(Order p) {
		conn = DButil.getConnection();
		return DButil.update(conn, "insert into order_ values(0,?,?,?,?,?,?,?,?)",
				p.getOid(),p.getAddress(),p.getReceiver(),p.getMobile(),
				p.getCreateDate(),p.getDeliveryDate(),p.getConfirmDate(),p.getStatus());
	}

	@Override
	public boolean delete(int id) {
		conn = DButil.getConnection();
		return DButil.update(conn, "delete from order_ where id=?", id);
	}

	@Override
	public boolean update(Order p) {
		conn = DButil.getConnection();
		return DButil.update(conn, "update order_ set oid=?,address=?,receiver=?,mobile=?"
				+ ",deliveryDate=?,confirmDate=?,status=? where id=?",
				p.getOid(),p.getAddress(),p.getReceiver(),p.getMobile(),
				p.getDeliveryDate(),p.getConfirmDate(),p.getStatus(),p.getId());
	}

	@Override
	public List<Order> selectAll() {
		conn = DButil.getConnection();
		return  DButil.queryList(conn, Order.class, "select * from order_", null);
	}

	@Override
	public Order selectById(int id) {
		conn = DButil.getConnection();
		return DButil.query(conn, Order.class, "select * from order_ where id=?", id);
	}

	@Override
	public Order selectByCode(int oid) {
		conn = DButil.getConnection();
		return DButil.query(conn, Order.class, "select * from order_ where oid=?", oid);
	}

	@Override
	public List<Order> selectStatus(String status) {
		conn = DButil.getConnection();
		return  DButil.queryList(conn, Order.class, "select * from order_ where status=?", status);
	}

	@Override
	public List<Order> selectSales() {
		conn = DButil.getConnection();
		return  DButil.queryList(conn, Order.class, "select * from order_ where status!='´ý·¢»õ'", null);
	}
	
}
