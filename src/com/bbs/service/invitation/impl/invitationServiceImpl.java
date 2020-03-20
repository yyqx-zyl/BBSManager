package com.bbs.service.invitation.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bbs.dao.invitation.invitationDao;
import com.bbs.dao.invitation.impl.invitationDaoImpl;
import com.bbs.entity.bbs_invitation;
import com.bbs.entity.bbs_invitation_ans;
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
	//id����
	@Override
	public bbs_invitation fundByid(String id) {
		bbs_invitation invi=dao.fundByid(id);
		if (invi!=null) {
			return invi;
		}else {
			return null;
		}
	}
	//�޸�
	@Override
	public boolean update(bbs_invitation invi) {
		int rs=dao.update(invi);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public Map<String, Object> invian(String id) {
		Map<String, Object> ins=new HashMap<String, Object>();
		//����id�ҵ���������Ϣ
		bbs_invitation invi=dao.fundByid(id);
		//���ָ��id�Ļظ�������
		List<bbs_invitation_ans> ans=dao.findeByid(id);
		//��������ݱ��浽map��
		ins.put("invi",invi);
		ins.put("ans",ans);
		
		return ins;
	}
	//��ӻ���
	@Override
	public boolean addAns(bbs_invitation_ans ans) {
		int result = dao.addAns(ans);
		if (result > 0) {
			return true;
		}else {
			return false;
		}
	}

}
