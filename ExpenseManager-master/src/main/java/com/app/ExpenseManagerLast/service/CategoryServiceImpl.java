package com.app.ExpenseManagerLast.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.ExpenseManagerLast.dto.CategoryDetails;
import com.app.ExpenseManagerLast.model.CategoryModel;
import com.app.ExpenseManagerLast.repository.CategoryRepository;

/**
 * Category service 
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<CategoryModel> getAllCategories() {
		// TODO Auto-generated method stub
		List<CategoryModel> categories = new ArrayList<>();
		categories=categoryRepository.findAll();
		return categories;
	}




}
