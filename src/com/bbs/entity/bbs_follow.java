package com.bbs.entity;
/**
 * ��ע
 * @author Zylyyqx
 *
 */

import java.util.Date;

public class bbs_follow {
	private String userId;//��ע��
	private String bUserId;//����ע��
	private Date  followDate;//��ע������
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getbUserId() {
		return bUserId;
	}
	public void setbUserId(String bUserId) {
		this.bUserId = bUserId;
	}
	public Date getFollowDate() {
		return followDate;
	}
	public void setFollowDate(Date followDate) {
		this.followDate = followDate;
	}
	public bbs_follow() {
		super();
	}
	
}
