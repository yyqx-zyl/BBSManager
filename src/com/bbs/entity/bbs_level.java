package com.bbs.entity;
/**
 * �˻��ȼ���Ϣ
 * @author Zylyyqx
 *
 */
public class bbs_level {
	private int levelId;//��������
	private String levelMessage;//�ȼ���Ϣ
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	public String getLevelMessage() {
		return levelMessage;
	}
	public void setLevelMessage(String levelMessage) {
		this.levelMessage = levelMessage;
	}
	public bbs_level(int levelId, String levelMessage) {
		super();
		this.levelId = levelId;
		this.levelMessage = levelMessage;
	}
	
	public bbs_level(String levelMessage) {
		super();
		this.levelMessage = levelMessage;
	}
	public bbs_level() {
		super();
	}
	
}
