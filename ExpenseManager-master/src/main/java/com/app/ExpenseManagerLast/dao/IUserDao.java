package com.app.ExpenseManagerLast.dao;


import com.app.ExpenseManagerLast.model.userModel;

public interface IUserDao {
	
	public	String registerUser(userModel user);
	
	public userModel loginUser(String email ,String password);
}

