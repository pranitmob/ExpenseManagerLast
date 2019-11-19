package com.app.ExpenseManagerLast.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.ExpenseManagerLast.dao.ICategoryDao;
import com.app.ExpenseManagerLast.model.categoryModel;

/**
 * @author Pranit Category service Imple
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryDao dao;

	@Override
	public List<categoryModel> getAllCategories() {
		// TODO Auto-generated method stub
		return dao.getAllCategories();
	}

}
