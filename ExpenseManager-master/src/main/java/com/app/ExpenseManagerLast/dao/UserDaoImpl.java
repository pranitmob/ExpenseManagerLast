package com.app.ExpenseManagerLast.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.ExpenseManagerLast.dto.UserDetails;
import com.app.ExpenseManagerLast.model.UserModel;
//import com.app.ExpenseManagerLast.model.userModel;
import com.app.ExpenseManagerLast.repository.UserRepository;


@Repository
@Transactional
public class UserDaoImpl implements IUserDao {
	
	@PersistenceContext
	private EntityManager entitytManager;
		
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public Integer registerUser(UserDetails user) {
		// TODO Auto-generated method stub
		UserModel userModel = new UserModel();
		userModel.setFirstName(user.getFirstName());
		userModel.setLastName(user.getLastName());
		userModel.setEmailId(user.getEmail());
		userModel.setPassword(user.getPassword());
		userModel.setConfirmPassword(user.getConfirmPassword());
		UserModel userDb = userRepo.save(userModel);
		
		System.out.println("User Registered with Id"+userDb.getUserId());

		return userDb.getUserId();
	}

	@Override
	public UserDetails loginUser(String email, String password) {
		// TODO Auto-generated method stub
		CriteriaBuilder cm =entitytManager.getCriteriaBuilder();
		CriteriaQuery<UserModel> cq = cm.createQuery(UserModel.class);
		Root<UserModel> root = cq.from(UserModel.class); 
		List<Predicate> predicates = new ArrayList<Predicate>();
		predicates.add(cm.equal(root.get("emailId"),email));
		predicates.add(cm.equal(root.get("password"), password));
		cq.select(root).where(predicates.toArray(new Predicate[] {}));
		UserModel user = entitytManager.createQuery(cq).getSingleResult();
		
		UserDetails userDto = new UserDetails();
		
		userDto.setFirstName(user.getFirstName());
		userDto.setEmail(user.getEmailId());
		userDto.setLastName(user.getLastName());
		
		System.out.println("user logged in "+user.getFirstName());
		//String jpql = "select u from userModel u where u.emailId=:em and u.password=:pwd";
		//userModel user = entitytManager.createQuery(jpql, userModel.class).setParameter("em", email).setParameter("pwd", password).getSingleResult();
		return userDto;
	}
	
}
