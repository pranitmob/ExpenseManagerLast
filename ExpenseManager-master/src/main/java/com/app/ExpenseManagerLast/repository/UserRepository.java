package com.app.ExpenseManagerLast.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ExpenseManagerLast.dto.UserDetails;
import com.app.ExpenseManagerLast.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
	
	UserModel findByemailIdAndPassword(String emailId ,String password);
}
