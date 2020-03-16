package com.bbs.service.user.impl;

import com.bbs.dao.User.Userdao;
import com.bbs.dao.User.impl.UserDaoImpl;
import com.bbs.service.user.CrudUser.UserService;

public class UserServiceImpl implements UserService {
	
	private	Userdao dao=new UserDaoImpl();
	@Override
	public boolean verification(String UserId, String UserPsw) {
		int rs=dao.verification(UserId, UserPsw);
		if (rs>0) {
			return true;
		}else {
			return false;
		}
		
	}

}
