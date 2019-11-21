package com.app.ExpenseManagerLast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ExpenseManagerLast.dao.IExpenseDao;
import com.app.ExpenseManagerLast.dto.ExpenseDetails;


/**
 * @author Pranit
 * Expense service implementation class
 */
@Service
public class ExpenseServiceImpl implements IExpenseService {

	@Autowired
	private IExpenseDao dao;

	@Override
	public String addExpense(ExpenseDetails expense) {
		// TODO Auto-generated method stub
		return dao.addExpense(expense);
	}

	@Override
	public List<Object[]> getListOfExpenses() {
		// TODO Auto-generated method stub
		return dao.getListOfExpenses();
	}

	@Override
	public Double sumOfallExpense() {
		// TODO Auto-generated method stub
		return dao.getSumOfAllExpenses();
	}
	
	
}
