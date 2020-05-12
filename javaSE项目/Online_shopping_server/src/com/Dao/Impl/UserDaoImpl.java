package com.Dao.Impl;

import java.sql.Connection;
import java.util.List;

import com.Dao.UserDao;
import com.entity.User;
import com.util.DButil;

public class UserDaoImpl implements UserDao{
	private Connection conn = null;
	@Override
	public List<User> selectAll() {
		conn = DButil.getConnection();
		return  DButil.queryList(conn, User.class, "select * from user", null);
	}

	@Override
	public User selectById(int id) {
		conn = DButil.getConnection();
		return DButil.query(conn, User.class, "select * from user where id=?", id);
	}

	@Override
	public User selectByAccountAndPassword(String account, String password) {
		conn = DButil.getConnection();
		return DButil.query(conn, User.class, "select * from user where account=? && password=?", account,password);
	}

	@Override
	public User selectByAccount(String account) {
		conn = DButil.getConnection();
		return DButil.query(conn, User.class, "select * from user where account=?", account);
	}

	@Override
	public User selectByName(String name) {
		conn = DButil.getConnection();
		return DButil.query(conn, User.class, "select * from user where name=?", name);
	}

	@Override
	public boolean deleteById(int id) {
		conn = DButil.getConnection();
		return DButil.update(conn, "delete from user where id=?", id);
	}

	@Override
	public boolean update(User user) {
		conn = DButil.getConnection();
		return DButil.update(conn, "update user set name=?,account=?,password=?,members=? where id=?",
				user.getName(),user.getAccount(),user.getPassword(),user.getStatus(),user.getId());
	}

	@Override
	public boolean insert(User user) {
		conn = DButil.getConnection();
		return DButil.update(conn, "insert into user values(0,?,?,?,?)",
				user.getName(),user.getAccount(),user.getPassword(),user.getStatus());
	}

}
