package com.service.Impl;

import java.util.List;

import com.Dao.OrderDao;
import com.Dao.Impl.OrderDaoImpl;
import com.entity.Order;
import com.service.OrderService;

public class OrderServiceImpl implements OrderService{
	OrderDao od = new OrderDaoImpl();
	@Override
	public String insert(Order p) {

		return od.insert(p)?"添加成功":"添加失败";
	}

	@Override
	public String delete(int id) {
		return od.delete(id)?"删除成功":"删除失败";
	}

	@Override
	public String update(Order p) {
		return od.update(p)?"修改成功":"修改失败";
	}

	@Override
	public List<Order> selectAll() {
		return od.selectAll();
	}

	@Override
	public Order selectById(int id) {
		return od.selectById(id);
	}

	@Override
	public Order selectByCode(int oid) {
		return od.selectByCode(oid);
	}

	@Override
	public List<Order> selectStatus(String status) {
		return od.selectStatus(status);
	}

	@Override
	public List<Order> selectSales() {
		return od.selectSales();
	}

}
