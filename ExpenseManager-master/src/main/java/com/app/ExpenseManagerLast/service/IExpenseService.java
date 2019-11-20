package com.app.ExpenseManagerLast.service;

import java.util.List;

import com.app.ExpenseManagerLast.model.ExpenseModel;

public interface IExpenseService {

	String addExpense(ExpenseModel expense);

	List<Object> getListOfExpenses();
}
