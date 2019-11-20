package com.app.ExpenseManagerLast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ExpenseManagerLast.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}
