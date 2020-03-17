package com.bbs.dao.User;

import java.util.List;

import com.bbs.entity.bbs_user;

public interface UserCrudsDao {
	
	int verification(String UserId,String UserPsw);
	
	int add(bbs_user user);

	public List<bbs_user> show();

	int delete(String userId);

	List<bbs_user> show(String userId);

	int cha(bbs_user user);

	int deleAll(String[] uids);



}
