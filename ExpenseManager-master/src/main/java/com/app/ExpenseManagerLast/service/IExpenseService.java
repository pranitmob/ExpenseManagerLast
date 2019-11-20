package com.app.ExpenseManagerLast.service;

import java.util.List;

import com.app.ExpenseManagerLast.dto.ExpenseDetails;

public interface IExpenseService {

	String addExpense(ExpenseDetails expense);

	List<Object> getListOfExpenses();
}
