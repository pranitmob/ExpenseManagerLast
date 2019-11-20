package com.app.ExpenseManagerLast.service;

import com.app.ExpenseManagerLast.dto.UserDetails;
import com.app.ExpenseManagerLast.model.UserModel;

public interface IUserService {

	//String resgiserUser(UserModel user);

	UserModel loginUser(String email, String password);
	
	Integer registerUserJPA(UserDetails user);
}
