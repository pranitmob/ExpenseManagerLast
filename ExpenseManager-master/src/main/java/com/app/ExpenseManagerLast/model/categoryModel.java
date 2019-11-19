package com.app.ExpenseManagerLast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class categoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;

	private String category;

	public categoryModel() {

	}

	public categoryModel(int categoryId, String category) {
		super();
		this.categoryId = categoryId;
		this.category = category;
	}

	@Column(name = "category_id")
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "categoryModel [categoryId=" + categoryId + ", category=" + category + "]";
	}
	
	// convience methods
}
