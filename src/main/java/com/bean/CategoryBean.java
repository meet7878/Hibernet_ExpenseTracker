package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // table
@Table(name = "category")
public class CategoryBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer categoryId;

//	@Column(name = "cname",length = 50,unique = true,nullable = false)
	String categoryName;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}