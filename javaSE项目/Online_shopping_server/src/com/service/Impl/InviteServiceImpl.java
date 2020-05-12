package com.service.Impl;

import java.util.List;

import com.Dao.InviteDao;
import com.Dao.Impl.InviteDaoImpl;
import com.entity.Invite;
import com.service.InviteService;

public class InviteServiceImpl implements InviteService {
	InviteDao idao = new InviteDaoImpl();
	@Override
	public String insert(Invite p) {

		return idao.insert(p)?"添加成功":"添加失败";
	}

	@Override
	public String delete(int code) {
		return idao.delete(code)?"删除成功":"删除失败";
	}

	@Override
	public String update(Invite p) {
		return idao.update(p)?"修改成功":"修改失败";
	}

	@Override
	public List<Invite> selectAll() {
		return idao.selectAll();
	}

	@Override
	public Invite selectByCode(int code) {
		return idao.selectByCode(code);
	}

}
