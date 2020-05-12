package com.service.Impl;

import java.util.List;

import com.Dao.UserDao;
import com.Dao.Impl.UserDaoImpl;
import com.entity.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao ud = new UserDaoImpl();
	@Override
	public List<User> selectAll() {
		return ud.selectAll();
	}

	@Override
	public User selectById(int id) {
		return ud.selectById(id);
	}

	@Override
	public User selectByAccountAndPassword(String account, String password) {
		return ud.selectByAccountAndPassword(account, password);
	}

	@Override
	public User selectByAccount(String account) {
		return ud.selectByAccount(account);
	}

	@Override
	public User selectByName(String name) {
		return ud.selectByName(name);
	}

	@Override
	public String deleteById(int id) {
		return ud.deleteById(id)?"ɾ���ɹ�":"ɾ��ʧ��";
	}

	@Override
	public String update(User user) {
		return ud.update(user)?"�޸ĳɹ�":"�޸�ʧ��";
	}

	@Override
	public String insert(User user) {
		if(ud.selectByAccount(user.getAccount())!=null)return "�û����Ѵ���";
		return ud.insert(user)?"��ӳɹ�":"���ʧ��";
	}
}
