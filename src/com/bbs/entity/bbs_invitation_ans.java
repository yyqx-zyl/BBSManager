package com.bbs.entity;
/**
 * ���ӻظ���Ϣ
 * @author Zylyyqx
 *
 */
public class bbs_invitation_ans {
	private int plateId;//��������
	private String plateTitle;//������
	private String plateMessage;//�������
	private int isEnable;//����Ƿ�����
	public int getPlateId() {
		return plateId;
	}
	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}
	public String getPlateTitle() {
		return plateTitle;
	}
	public void setPlateTitle(String plateTitle) {
		this.plateTitle = plateTitle;
	}
	public String getPlateMessage() {
		return plateMessage;
	}
	public void setPlateMessage(String plateMessage) {
		this.plateMessage = plateMessage;
	}
	public int getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}
	public bbs_invitation_ans(int plateId, String plateTitle, String plateMessage, int isEnable) {
		super();
		this.plateId = plateId;
		this.plateTitle = plateTitle;
		this.plateMessage = plateMessage;
		this.isEnable = isEnable;
	}
	public bbs_invitation_ans() {
		super();
	}
	
	
}
