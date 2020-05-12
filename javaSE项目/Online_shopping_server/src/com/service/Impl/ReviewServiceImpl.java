package com.service.Impl;

import java.util.List;

import com.Dao.ReviewDao;
import com.Dao.Impl.ReviewDaoImpl;
import com.entity.Order;
import com.entity.Product;
import com.entity.Review;
import com.service.ReviewService;

public class ReviewServiceImpl implements ReviewService {
	ReviewDao rd = new ReviewDaoImpl();
	@Override
	public String insert(Review p) {
		return rd.insert(p)?"��ӳɹ�":"���ʧ��";
	}

	@Override
	public String delete(int id) {
		return rd.delete(id)?"ɾ���ɹ�":"ɾ��ʧ��";
	}

	@Override
	public String update(Review p) {
		return rd.update(p)?"�޸ĳɹ�":"�޸�ʧ��";
	}

	@Override
	public List<Review> selectAll() {
		return rd.selectAll();
	}

	@Override
	public Review selectById(int id) {
		return rd.selectById(id);
	}

	@Override
	public Review selectByCode(int oid) {
		return rd.selectByCode(oid);
	}

}
