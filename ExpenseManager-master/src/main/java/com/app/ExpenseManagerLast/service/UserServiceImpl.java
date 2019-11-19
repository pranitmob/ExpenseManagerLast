package com.app.ExpenseManagerLast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ExpenseManagerLast.Exception.UserNotFoundException;
import com.app.ExpenseManagerLast.dao.IUserDao;
import com.app.ExpenseManagerLast.model.userModel;

/**
 * @author Pranit User service Implementation Class
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public String resgiserUser(userModel user) {
		// TODO Auto-generated method stub
		return userDao.registerUser(user);
	}

	@Override
	public userModel loginUser(String email, String password) {
		// TODO Auto-generated method stub
		userModel user = userDao.loginUser(email, password);
		if(user==null) {
			throw new UserNotFoundException("please register before login");
		}
		return user;
	}

}
