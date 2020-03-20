package com.bbs.service.invitation.impl;

import java.util.List;

import com.bbs.dao.invitation.invitationDao;
import com.bbs.dao.invitation.impl.invitationDaoImpl;
import com.bbs.entity.bbs_invitation;
import com.bbs.service.invitation.invitationService;

public class invitationServiceImpl implements invitationService {
	invitationDao dao=new invitationDaoImpl();
	//��ʾ����
	@Override
	public List<bbs_invitation> showAll() {
		List<bbs_invitation> invi=dao.showAll();
		if (invi!=null) {
			return invi;
		}else {
			return invi;
		}
	}
	//���
	@Override
	public boolean add(bbs_invitation invi) {
		int rs=dao.add(invi);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
		
	}
	//ɾ��
	@Override
	public boolean deletByid(String invitationId) {
		int rs=dao.deleteByid(invitationId);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
	}

}
