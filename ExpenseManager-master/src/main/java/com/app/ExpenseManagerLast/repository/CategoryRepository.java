package com.app.ExpenseManagerLast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ExpenseManagerLast.model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel,Long>{
	
	
	
}
