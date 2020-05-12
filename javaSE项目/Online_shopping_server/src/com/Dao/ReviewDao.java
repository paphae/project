package com.Dao;

import java.util.List;

import com.entity.Order;
import com.entity.Product;
import com.entity.Review;

public interface ReviewDao {
	boolean insert(Review p);
	boolean delete(int id);
	boolean update(Review p);
	List<Review> selectAll();
	Review selectById(int id);
	Review selectByCode(int oid);
}
