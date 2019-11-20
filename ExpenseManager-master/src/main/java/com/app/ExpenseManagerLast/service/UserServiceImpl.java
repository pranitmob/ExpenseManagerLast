package com.app.ExpenseManagerLast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ExpenseManagerLast.Exception.UserNotFoundException;
import com.app.ExpenseManagerLast.dto.UserDetails;
import com.app.ExpenseManagerLast.model.UserModel;
import com.app.ExpenseManagerLast.repository.UserRepository;

/**
 * @author Pranit User service Implementation Class
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserModel loginUser(String email, String password) {
		// TODO Auto-generated method stub
		UserModel user = userRepository.findByemailIdAndPassword(email, password);
		if(user==null) {
			throw new UserNotFoundException("please register before login");
		}
		return user;
	}

	@Override
	public Integer registerUserJPA(UserDetails user) {
		// TODO Auto-generated method stub
		UserModel userModel = new UserModel();
		userModel.setFirstName(user.getFirstName());
		userModel.setLastName(user.getLastName());
		userModel.setEmailId(user.getEmail());
		userModel.setPassword(user.getPassword());
		userModel.setConfirmPassword(user.getConfirmPassword());
		UserModel userDb = userRepository.save(userModel);
		System.out.println("User Registered with id"+userDb.getUserId());
		
		return userDb.getUserId();
		
	}

}
