package com.bbs.entity;
/**
 * 关注
 * @author Zylyyqx
 *
 */

import java.util.Date;

public class bbs_follow {
	private String userId;//关注者
	private String bUserId;//被关注者
	private Date  followDate;//关注的日期
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
