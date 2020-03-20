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
	//显示所有
	@Override
	public List<bbs_invitation> showAll() {
		List<bbs_invitation> invi=dao.showAll();
		if (invi!=null) {
			return invi;
		}else {
			return invi;
		}
	}
	//添加
	@Override
	public boolean add(bbs_invitation invi) {
		int rs=dao.add(invi);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
		
	}
	//删除
	@Override
	public boolean deletByid(String invitationId) {
		int rs=dao.deleteByid(invitationId);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
	}
	//id查找
	@Override
	public bbs_invitation fundByid(String id) {
		bbs_invitation invi=dao.fundByid(id);
		if (invi!=null) {
			return invi;
		}else {
			return null;
		}
	}
	//修改
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
		//根据id找到的帖子信息
		bbs_invitation invi=dao.fundByid(id);
		//获得指定id的回复的数据
		List<bbs_invitation_ans> ans=dao.findeByid(id);
		//讲获得数据保存到map里
		ins.put("invi",invi);
		ins.put("ans",ans);
		
		return ins;
	}
	//添加回帖
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
