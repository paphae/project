package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {
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
		String deleteById(int id);

		// �޸ĵķ���
		String update(User user);

		// ���ӵķ���
		String insert(User user);
}
