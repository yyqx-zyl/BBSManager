package com.bbs.entity;
/**
 * ���
 * @author Zylyyqx
 *
 */
public class bbs_plate {
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
	
	public bbs_plate(String plateTitle, String plateMessage) {
		super();
		this.plateTitle = plateTitle;
		this.plateMessage = plateMessage;
	}
	public bbs_plate(int plateId, String plateTitle, String plateMessage, int isEnable) {
		super();
		this.plateId = plateId;
		this.plateTitle = plateTitle;
		this.plateMessage = plateMessage;
		this.isEnable = isEnable;
	}
	public bbs_plate(String plateTitle, String plateMessage, int isEnable) {
		super();
		this.plateTitle = plateTitle;
		this.plateMessage = plateMessage;
		this.isEnable = isEnable;
	}
	public bbs_plate() {
		super();
	}
	  
	
}
