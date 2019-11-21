package com.app.ExpenseManagerLast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ExpenseManagerLast.dao.ICategoryDao;

/**
 * Category service 
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private ICategoryDao dao;
	
	@Override
	public List<Object> getAllCategories() {
		// TODO Auto-generated method stub
		return dao.getAllCategories();
	}




}
