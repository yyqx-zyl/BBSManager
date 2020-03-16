package com.bbs.dao.User;
/**
 * 
 * @author Zylyyqx
 *
 */
public interface Userdao {
	//验证登录的方法
	/**
	 * 
	 * @param UserId 用户名
	 * @param UserPsw 密码
	 * @return 用户名和密码相同的个数
	 */
	int verification(String UserId,String UserPsw);
}
