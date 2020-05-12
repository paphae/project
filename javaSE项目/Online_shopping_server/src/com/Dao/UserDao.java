package com.Dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	// 查询所有的方法
	List<User> selectAll();

	// 根据id查询的方法
	User selectById(int id);

	// 根据用户名密码查询的方法
	User selectByAccountAndPassword(String account, String password);

	// 添加一个根据用户名查询的方法
	User selectByAccount(String account);

	// 添加一个根据姓名查询的方法
	User selectByName(String name);

	// 删除的方法
	boolean deleteById(int id);

	// 修改的方法
	boolean update(User user);

	// 增加的方法
	boolean insert(User user);
}
