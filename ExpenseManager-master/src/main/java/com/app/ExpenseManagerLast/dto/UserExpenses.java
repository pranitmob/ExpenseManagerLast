package com.app.ExpenseManagerLast.dto;

import java.util.List;

public class UserExpenses {
	
		
		private Integer userId;
	
		private List<ExpenseDetails> UserExpenses;

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public List<ExpenseDetails> getUserExpenses() {
			return UserExpenses;
		}

		public void setUserExpenses(List<ExpenseDetails> userExpenses) {
			UserExpenses = userExpenses;
		}
	

}
