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

		return od.insert(p)?"��ӳɹ�":"���ʧ��";
	}

	@Override
	public String delete(int id) {
		return od.delete(id)?"ɾ���ɹ�":"ɾ��ʧ��";
	}

	@Override
	public String update(OrderItem p) {
		return od.update(p)?"�޸ĳɹ�":"�޸�ʧ��";
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
