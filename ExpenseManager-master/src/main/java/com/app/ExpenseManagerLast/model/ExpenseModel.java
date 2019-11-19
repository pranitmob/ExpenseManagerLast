package com.app.ExpenseManagerLast.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "expense")
public class ExpenseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int expenseId;

	@NotEmpty(message = "expense name cannot be empty")
	private String expenseName;

	@Min(1)
	private double expenseAmount;

	@Past(message = "date must be past")
	
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@NotEmpty(message = "category cannot be empty")
	private String category;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private userModel user;
	
	public ExpenseModel() {

	}
		
	public ExpenseModel(int expenseId,String expenseName,double expenseAmount,Date createDate,String category, userModel user) {
		super();
		this.expenseId = expenseId;
		this.expenseName = expenseName;
		this.expenseAmount = expenseAmount;
		this.createDate = createDate;
		this.category = category;
		this.user = user;
	}


	@Column(name = "expense_id")
	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	@Column(name = "category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "expense_name")
	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	@Column(name = "expense_amount")
	public double getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	@Column(name = "expense_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "ExpenseModel [expenseId=" + expenseId + ", expenseName=" + expenseName + ", expenseAmount="
				+ expenseAmount + ", createDate=" + createDate + ", category=" + category + ", user=" + user + "]";
	}
	
	
}
