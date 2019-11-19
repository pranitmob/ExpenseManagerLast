package com.app.ExpenseManagerLast.service;

import com.app.ExpenseManagerLast.model.userModel;

public interface IUserService {

	public String resgiserUser(userModel user);

	public userModel loginUser(String email, String password);

}
