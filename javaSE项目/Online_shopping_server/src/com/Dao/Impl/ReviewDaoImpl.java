package com.Dao.Impl;

import java.sql.Connection;
import java.util.List;

import com.Dao.ReviewDao;
import com.entity.Review;
import com.util.DButil;

public class ReviewDaoImpl implements ReviewDao{
	Connection conn = null;
	@Override
	public boolean insert(Review p) {
		conn = DButil.getConnection();
		return DButil.update(conn, "insert into review values(0,?,?,?,?)",
				p.getContent(),p.getUid(),p.getOid(),p.getCreateDate());
	}

	@Override
	public boolean delete(int id) {
		conn = DButil.getConnection();
		return DButil.update(conn, "delete from review where id=?", id);
	}

	@Override
	public boolean update(Review p) {
		conn = DButil.getConnection();
		return DButil.update(conn, "update review set content=?,uid=?,pid=?,createDate=? where id=?",
				p.getContent(),p.getUid(),p.getOid(),p.getCreateDate(),p.getId());
	}

	@Override
	public List<Review> selectAll() {
		conn = DButil.getConnection();
		return  DButil.queryList(conn, Review.class, "select * from review", null);
	}

	@Override
	public Review selectById(int id) {
		conn = DButil.getConnection();
		return DButil.query(conn, Review.class, "select * from review where id=?", id);
	}

	@Override
	public Review selectByCode(int oid) {
		conn = DButil.getConnection();
		return DButil.query(conn, Review.class, "select r.* from order_ o,review r where o.id=r.oid and o.id=?", oid);
	}


	
}
