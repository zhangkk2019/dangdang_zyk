package com.baizhi.entity;

import java.util.List;

//分类表
public class Category {
	private String id;
	private String name;
	private String parentId;
	private String levels;
	private Category category;//父类对象
	private List<Category> cateList;//子类集合
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String id, String name, String parentId, String levels,
			Category category, List<Category> cateList) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.levels = levels;
		this.category = category;
		this.cateList = cateList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getCateList() {
		return cateList;
	}
	public void setCateList(List<Category> cateList) {
		this.cateList = cateList;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parentId="
				+ parentId + ", levels=" + levels + ", category=" + category
				+ ", cateList=" + cateList + "]";
	}
	
}
