package com.bbs.entity;
/**
 * �ղ�����
 */
import java.util.Date;

public class bbs_store {
	private String userId;//
	private String invitationId;
	private Date storeDate;//�ղ�����ʱ��
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
	}
	public Date getStoreDate() {
		return storeDate;
	}
	public void setStoreDate(Date storeDate) {
		this.storeDate = storeDate;
	}
	
	public bbs_store() {
		super();
	}
	
}
