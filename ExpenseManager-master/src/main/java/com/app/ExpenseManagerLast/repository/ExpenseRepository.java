package com.app.ExpenseManagerLast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ExpenseManagerLast.model.ExpenseModel;

public interface ExpenseRepository extends JpaRepository<ExpenseModel, Integer> {
	
	
}
