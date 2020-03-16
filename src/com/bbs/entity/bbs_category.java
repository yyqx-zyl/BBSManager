package com.bbs.entity;
/**
 * 帖子分类
 * @author Zylyyqx
 *
 */
public class bbs_category {
	private int categoryId;//自增主键
	private String category;//分类名
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
