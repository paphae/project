package com.service;

import java.util.List;

import com.entity.Invite;

public interface InviteService {
	String insert(Invite p);
	String delete(int code);
	String update(Invite p);
	List<Invite> selectAll();
	Invite selectByCode(int code);
}
