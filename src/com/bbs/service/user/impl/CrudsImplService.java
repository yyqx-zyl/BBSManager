package com.bbs.service.user.impl;

import java.util.List;

import com.bbs.dao.User.Userdao;
import com.bbs.dao.User.CrudUser.UserCrudsDao;
import com.bbs.dao.User.CrudUser.impl.UserCrudsImplDao;
import com.bbs.dao.User.impl.UserDaoImpl;
import com.bbs.entity.bbs_user;
import com.bbs.service.user.CrudsService;
/**
 * 增删改查
 * @author Zylyyqx
 *
 */
public class CrudsImplService implements CrudsService {
		private	UserCrudsDao dao=new UserCrudsImplDao();
		
	@Override
	public boolean verification(String UserId, String UserPsw) {
		int rs=dao.verification(UserId, UserPsw);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	//增加
	@Override
	public boolean add(bbs_user user) {
		int rs=dao.add(user);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
		
	}
	//显示用户数据
	@Override
	public List<bbs_user> show() {
		List<bbs_user> user=dao.show();
		if (user!=null) {
			return user;
		}else {
			return null;
		}
	}
	//删除
	@Override
	public boolean delete(String userId) {
		int rs=dao.delete(userId);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
		
	}
	//根据id查询
	@Override
	public List<bbs_user> show(String userId) {
		List<bbs_user> user=dao.show(userId);
		if (user!=null) {
			return user;
		}else {
			return null;
		}
	}
	//修改
	@Override
	public boolean cha(bbs_user user) {
		int rs=dao.cha(user);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
	}
	//批量删除
	@Override
	public boolean delAll(String userIds) {
		//截取[]中的数据
		userIds = userIds.substring(1,userIds.lastIndexOf("]")).replaceAll("\"","");
		//字符串拆分
		String[] uids=userIds.split(",");
		int rs=dao.deleAll(uids);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
