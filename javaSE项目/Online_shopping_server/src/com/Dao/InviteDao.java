package com.Dao;

import java.util.List;

import com.entity.Invite;

public interface InviteDao {
	boolean insert(Invite p);
	boolean delete(int code);
	boolean update(Invite p);
	List<Invite> selectAll();
	Invite selectByCode(int code);
}
