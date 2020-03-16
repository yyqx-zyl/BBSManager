package com.bbs.entity;
/**
 * 收藏帖子
 */
import java.util.Date;

public class bbs_store {
	private String userId;//
	private String invitationId;
	private Date storeDate;//收藏日期时间
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
