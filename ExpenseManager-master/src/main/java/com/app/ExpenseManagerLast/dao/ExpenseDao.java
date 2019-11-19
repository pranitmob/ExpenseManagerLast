package com.app.ExpenseManagerLast.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.app.ExpenseManagerLast.model.ExpenseModel;
import com.app.ExpenseManagerLast.model.userModel;

@Repository
@Transactional
public class ExpenseDao implements IExpenseDao{
	
	@PersistenceContext
	private EntityManager entitytManager;

	@Override
	public String addExpense(ExpenseModel expense) {
		// TODO Auto-generated method stub
		entitytManager.persist(expense);
		return "Expense Added";
	}

	@Override
	public List<Object> getListOfExpenses() {
		// TODO Auto-generated method stub
		
//		CriteriaBuilder criteriaBuilder = entitytManager.getCriteriaBuilder();
//		CriteriaQuery<ExpenseModel> criteriaQuery = criteriaBuilder.createQuery(ExpenseModel.class);
//		Root<ExpenseModel> root = criteriaQuery.from(ExpenseModel.class);
//		criteriaQuery.select(root).where(criteriaBuilder.equal()
		String jpql = "select monthname(e.createDate),YEAR(e.createDate), SUM(e.expenseAmount) from ExpenseModel e GROUP BY monthname(e.createDate) ";
		List<Object> data = new ArrayList<Object>();
		data = entitytManager.createQuery(jpql).getResultList();
		return data; 
	}

}
