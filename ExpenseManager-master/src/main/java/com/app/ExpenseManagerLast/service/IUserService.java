package com.app.ExpenseManagerLast.service;

import com.app.ExpenseManagerLast.dto.UserDetails;

public interface IUserService {

	//String resgiserUser(UserModel user);

	UserDetails loginUser(String email, String password);
	
	Integer registerUserJPA(UserDetails user);
}
