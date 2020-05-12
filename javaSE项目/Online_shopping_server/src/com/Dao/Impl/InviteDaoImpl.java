package com.Dao.Impl;

import java.sql.Connection;
import java.util.List;

import com.Dao.InviteDao;
import com.entity.Invite;
import com.entity.Order;
import com.util.DButil;

public class InviteDaoImpl implements InviteDao {
	Connection conn = null;
	@Override
	public boolean insert(Invite p) {
		conn = DButil.getConnection();
		return DButil.update(conn, "insert into invite(status) values(?)",
				p.getStatus());

	}

	@Override
	public boolean delete(int code) {
		conn = DButil.getConnection();
		return DButil.update(conn, "delete from invite where code=?",
				code);
	}

	@Override
	public boolean update(Invite p) {
		conn = DButil.getConnection();
		return DButil.update(conn, "update invite set status=? where code=?",
				p.getStatus(),p.getCode());
	}

	@Override
	public List<Invite> selectAll() {
		conn = DButil.getConnection();
		return  DButil.queryList(conn, Invite.class, "select * from invite", null);
	}

	@Override
	public Invite selectByCode(int code) {
		conn = DButil.getConnection();
		return  DButil.query(conn, Invite.class, "select * from invite where code=?", code);
	}

}
