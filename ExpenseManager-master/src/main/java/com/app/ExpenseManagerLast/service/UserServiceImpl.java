package com.app.ExpenseManagerLast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ExpenseManagerLast.Exception.UserNotFoundException;
import com.app.ExpenseManagerLast.dao.IUserDao;
import com.app.ExpenseManagerLast.dto.UserDetails;


/**
 * @author Pranit User service Implementation Class
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public UserDetails loginUser(String email, String password) {
		// TODO Auto-generated method stub
		UserDetails userDto = userDao.loginUser(email, password);
		if(userDto==null) {
			throw new UserNotFoundException("please register before login");
		}
		return userDto;
	}

	@Override
	public Integer registerUserJPA(UserDetails user) {
		// TODO Auto-generated method stub
	
		return userDao.registerUser(user);
		
	}

}
