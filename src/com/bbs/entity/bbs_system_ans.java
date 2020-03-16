package com.bbs.entity;
/**
 * 管理员回复信息表
 * @author Zylyyqx
 *
 */

import java.util.Date;

public class bbs_system_ans {
	private  String systemId;
	private String userId;//接收此信息的账户id
	private String message;//发送的消息信息
	private int isRead;//是否已读
	private Date createDate;//消息创建时间
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
