package com.app.ExpenseManagerLast.dao;


import com.app.ExpenseManagerLast.dto.UserDetails;

public interface IUserDao {
	
	public	Integer registerUser(UserDetails user);
	
	public UserDetails loginUser(String email ,String password);
}

