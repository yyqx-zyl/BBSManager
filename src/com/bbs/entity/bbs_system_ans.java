package com.bbs.entity;
/**
 * ����Ա�ظ���Ϣ��
 * @author Zylyyqx
 *
 */

import java.util.Date;

public class bbs_system_ans {
	private  String systemId;
	private String userId;//���մ���Ϣ���˻�id
	private String message;//���͵���Ϣ��Ϣ
	private int isRead;//�Ƿ��Ѷ�
	private Date createDate;//��Ϣ����ʱ��
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getIsRead() {
		return isRead;
	}
	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public bbs_system_ans() {
		super();
	}
	
	
}
