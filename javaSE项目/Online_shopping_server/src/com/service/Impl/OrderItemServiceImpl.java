package com.service.Impl;

import java.util.List;

import com.Dao.OrderItemDao;
import com.Dao.Impl.OrderItemDaoImpl;
import com.entity.OrderItem;
import com.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {
	OrderItemDao od = new OrderItemDaoImpl();
	@Override
	public String insert(OrderItem p) {

		return od.insert(p)?"添加成功":"添加失败";
	}

	@Override
	public String delete(int id) {
		return od.delete(id)?"删除成功":"删除失败";
	}

	@Override
	public String update(OrderItem p) {
		return od.update(p)?"修改成功":"修改失败";
	}

	@Override
	public List<OrderItem> selectAll() {
		return od.selectAll();
	}

	@Override
	public OrderItem selectById(int id) {
		return od.selectById(id);
	}

}
