package com.app.ExpenseManagerLast.dto;

import java.util.List;

public class CategoryDetails {
	
	private Integer categoryId;
	
	private List<CategoryDetails> categories;

	
	public List<CategoryDetails> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDetails> categories) {
		this.categories = categories;
	}

//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
