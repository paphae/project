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

		return idao.insert(p)?"��ӳɹ�":"���ʧ��";
	}

	@Override
	public String delete(int code) {
		return idao.delete(code)?"ɾ���ɹ�":"ɾ��ʧ��";
	}

	@Override
	public String update(Invite p) {
		return idao.update(p)?"�޸ĳɹ�":"�޸�ʧ��";
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
