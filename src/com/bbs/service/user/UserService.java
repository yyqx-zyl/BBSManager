package com.bbs.service.user;

import java.util.List;

import com.bbs.entity.bbs_user;

public interface UserService {
	boolean verification(String UserId,String UserPsw);
	
	boolean add(bbs_user user);

	public List<bbs_user> show();

	boolean delete(String userId);
	//¸ù¾Ýid²éÑ¯
	List<bbs_user> show(String userId);

	boolean cha(bbs_user user);

	boolean delAll(String userIds);

	
}
