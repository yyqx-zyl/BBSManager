package com.bbs.dao.User;
/**
 * 
 * @author Zylyyqx
 *
 */
public interface Userdao {
	//��֤��¼�ķ���
	/**
	 * 
	 * @param UserId �û���
	 * @param UserPsw ����
	 * @return �û�����������ͬ�ĸ���
	 */
	int verification(String UserId,String UserPsw);
}
