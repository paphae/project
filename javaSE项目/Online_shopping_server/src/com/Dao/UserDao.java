package com.Dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	// ��ѯ���еķ���
	List<User> selectAll();

	// ����id��ѯ�ķ���
	User selectById(int id);

	// �����û��������ѯ�ķ���
	User selectByAccountAndPassword(String account, String password);

	// ���һ�������û�����ѯ�ķ���
	User selectByAccount(String account);

	// ���һ������������ѯ�ķ���
	User selectByName(String name);

	// ɾ���ķ���
	boolean deleteById(int id);

	// �޸ĵķ���
	boolean update(User user);

	// ���ӵķ���
	boolean insert(User user);
}
