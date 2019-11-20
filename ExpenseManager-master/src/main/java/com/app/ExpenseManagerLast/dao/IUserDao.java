package com.app.ExpenseManagerLast.dao;


import com.app.ExpenseManagerLast.model.UserModel;

public interface IUserDao {
	
	public UserModel loginUser(String email ,String password);
}

