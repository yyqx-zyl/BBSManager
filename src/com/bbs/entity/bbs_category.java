package com.bbs.entity;
/**
 * ���ӷ���
 * @author Zylyyqx
 *
 */
public class bbs_category {
	private int categoryId;//��������
	private String category;//������
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public bbs_category(int categoryId, String category) {
		super();
		this.categoryId = categoryId;
		this.category = category;
	}
	public bbs_category() {
		super();
	}
	
}
