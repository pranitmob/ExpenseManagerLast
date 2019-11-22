package com.app.ExpenseManagerLast.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.ExpenseManagerLast.dto.ExpenseDetails;
import com.app.ExpenseManagerLast.model.ExpenseModel;
import com.app.ExpenseManagerLast.repository.ExpenseRepository;

@Repository
@Transactional
public class ExpenseDao implements IExpenseDao {

	@PersistenceContext
	private EntityManager entitytManager;

	@Autowired
	private ExpenseRepository expenseRepo;

	@Override
	public String addExpense(ExpenseDetails expenseDto) {
		// TODO Auto-generated method stub
		ExpenseModel expense = new ExpenseModel();
		expense.setExpenseName(expenseDto.getName());
		expense.setCreateDate(expenseDto.getDate());
		expense.setExpenseAmount(expenseDto.getAmount());
		expense.setCategory(expenseDto.getCategory());
		expense.setDescription(expenseDto.getDescription());
		ExpenseModel expenseDb = expenseRepo.save(expense);
		return "Expense added with name" + expenseDb.getExpenseName();
	}

	@Override
	public List<Object[]> getListOfExpenses() {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entitytManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
		Root<ExpenseModel> root = criteriaQuery.from(ExpenseModel.class);
		Expression<Integer> year = criteriaBuilder.function("year", Integer.class, root.get("createDate"));
		Expression<String> monthName = criteriaBuilder.function("monthname", String.class, root.get("createDate"));
		Expression<Integer> summ = criteriaBuilder.sum(root.get("expenseAmount"));
		criteriaQuery.multiselect(year, monthName, summ).groupBy(monthName);
		List<Object[]> expenses = new ArrayList<Object[]>();
		expenses = entitytManager.createQuery(criteriaQuery).getResultList();
		// String jpql = "select monthname(e.createDate),YEAR(e.createDate),
		// SUM(e.expenseAmount) from ExpenseModel e GROUP BY monthname(e.createDate) ";
		// List<Object> data = new ArrayList<Object>();
		return expenses;
	}

	@Override
	public Double getSumOfAllExpenses() {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entitytManager.getCriteriaBuilder();
		CriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);
		Root<ExpenseModel> root = criteriaQuery.from(ExpenseModel.class);
		criteriaQuery.select(criteriaBuilder.sum(root.get("expenseAmount")));
		TypedQuery<Double> typedQuery = entitytManager.createQuery(criteriaQuery);
		return typedQuery.getSingleResult();
	}

}
