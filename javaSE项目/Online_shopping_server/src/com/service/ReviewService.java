package com.service;

import java.util.List;

import com.entity.Product;
import com.entity.Review;

public interface ReviewService {
	String insert(Review p);
	String delete(int id);
	String update(Review p);
	List<Review> selectAll();
	Review selectById(int id);
	Review selectByCode(int oid);
}
