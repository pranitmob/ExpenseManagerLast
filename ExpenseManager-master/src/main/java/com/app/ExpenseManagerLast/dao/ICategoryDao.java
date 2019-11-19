package com.app.ExpenseManagerLast.dao;

import java.util.List;

import com.app.ExpenseManagerLast.model.categoryModel;

public interface ICategoryDao {
	
	public List<categoryModel> getAllCategories();
}
