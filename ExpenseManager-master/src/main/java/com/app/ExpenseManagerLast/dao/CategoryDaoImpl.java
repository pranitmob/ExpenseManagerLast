package com.app.ExpenseManagerLast.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.ExpenseManagerLast.model.CategoryModel;
import com.app.ExpenseManagerLast.repository.CategoryRepository;

@Repository
public class CategoryDaoImpl implements ICategoryDao {

	@Autowired
	private CategoryRepository catRepo;
	
	@Override
	public List<Object> getAllCategories() {
		// TODO Auto-generated method stub
		List<CategoryModel> c = catRepo.findAll();
		List<Object> obj = new ArrayList<Object>();
		obj.addAll(c);
			
		return obj;
	}

}
