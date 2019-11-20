package com.app.ExpenseManagerLast.dao;

import java.util.List;

import com.app.ExpenseManagerLast.dto.ExpenseDetails;


public interface IExpenseDao {
	
	String addExpense(ExpenseDetails expense);
	
	List<Object> getListOfExpenses();
}
