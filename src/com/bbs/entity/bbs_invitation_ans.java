package com.bbs.entity;
/**
 * ������
 * @author Effort
 *
 */

import java.util.Date;

public class bbs_invitation_ans {

	private String ansId;//�ظ�id
	private String ansMessage;//�ظ�����
	private String invitationId;//�ظ�����id
	private String userId;//�ظ��˻�id
	private Date  ansDate;//�ظ�ʱ��
	public String getAnsId() {
		return ansId;
	}
	public void setAnsId(String ansId) {
		this.ansId = ansId;
	}
	public String getAnsMessage() {
		return ansMessage;
	}
	public void setAnsMessage(String ansMessage) {
		this.ansMessage = ansMessage;
	}
	public String getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getAnsDate() {
		return ansDate;
	}
	public void setAnsDate(Date ansDate) {
		this.ansDate = ansDate;
	}
	public bbs_invitation_ans(String ansId, String ansMessage, String invitationId, String userId, Date ansDate) {
		super();
		this.ansId = ansId;
		this.ansMessage = ansMessage;
		this.invitationId = invitationId;
		this.userId = userId;
		this.ansDate = ansDate;
	}
	public bbs_invitation_ans() {
		super();
	}
	public bbs_invitation_ans(String ansId, String ansMessage, String invitationId, String userId) {
		super();
		this.ansId = ansId;
		this.ansMessage = ansMessage;
		this.invitationId = invitationId;
		this.userId = userId;
	}
	
	
	
}