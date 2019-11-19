package com.app.ExpenseManagerLast.dao;

import java.util.List;

import com.app.ExpenseManagerLast.model.ExpenseModel;

public interface IExpenseDao {
	
	String addExpense(ExpenseModel expense);
	
	List<Object> getListOfExpenses();
}
