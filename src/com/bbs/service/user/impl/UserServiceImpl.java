package com.bbs.service.user.impl;

import java.util.List;

import com.bbs.dao.User.UserDao;
import com.bbs.dao.User.impl.UserDaoImpl;
import com.bbs.entity.bbs_user;
import com.bbs.service.user.UserService;
/**
 * ��ɾ�Ĳ�
 * @author Zylyyqx
 *
 */
public class UserServiceImpl implements UserService {
		private	UserDao dao=new UserDaoImpl();
		
	@Override
	public boolean verification(String UserId, String UserPsw) {
		int rs=dao.verification(UserId, UserPsw);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	//����
	@Override
	public boolean add(bbs_user user) {
		int rs=dao.add(user);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
		
	}
	//��ʾ�û�����
	@Override
	public List<bbs_user> show() {
		List<bbs_user> user=dao.show();
		if (user!=null) {
			return user;
		}else {
			return null;
		}
	}
	//ɾ��
	@Override
	public boolean delete(String userId) {
		int rs=dao.delete(userId);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
		
	}
	//����id��ѯ
	@Override
	public List<bbs_user> show(String userId) {
		List<bbs_user> user=dao.show(userId);
		if (user!=null) {
			return user;
		}else {
			return null;
		}
	}
	//�޸�
	@Override
	public boolean cha(bbs_user user) {
		int rs=dao.cha(user);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
	}
	//����ɾ��
	@Override
	public boolean delAll(String userIds) {
		//��ȡ[]�е�����
		userIds = userIds.substring(1,userIds.lastIndexOf("]")).replaceAll("\"","");
		//�ַ������
		String[] uids=userIds.split(",");
		int rs=dao.deleAll(uids);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}