package com.app.ExpenseManagerLast.service;

import java.util.List;

import com.app.ExpenseManagerLast.model.ExpenseModel;

public interface IExpenseService {

	public String addExpense(ExpenseModel expense);

	public List<Object> getListOfExpenses();
}
