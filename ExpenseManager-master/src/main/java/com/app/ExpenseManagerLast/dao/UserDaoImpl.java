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
import org.springframework.stereotype.Repository;
import com.app.ExpenseManagerLast.model.userModel;


@Repository
@Transactional
public class UserDaoImpl implements IUserDao {
	
	@PersistenceContext
	private EntityManager entitytManager;
	
	@Override
	public String registerUser(userModel user) {
		// TODO Auto-generated method stub
		entitytManager.persist(user);
		return"Registered";
	}

	@Override
	public userModel loginUser(String email, String password) {
		// TODO Auto-generated method stub
		CriteriaBuilder cm =entitytManager.getCriteriaBuilder();
		CriteriaQuery<userModel> cq = cm.createQuery(userModel.class);
		Root<userModel> root = cq.from(userModel.class); 
		List<Predicate> predicates = new ArrayList<Predicate>();
		predicates.add(cm.equal(root.get("emailId"),email));
		predicates.add(cm.equal(root.get("password"), password));
		cq.select(root).where(predicates.toArray(new Predicate[] {}));
		userModel user = entitytManager.createQuery(cq).getSingleResult();
		
		//String jpql = "select u from userModel u where u.emailId=:em and u.password=:pwd";
		//userModel user = entitytManager.createQuery(jpql, userModel.class).setParameter("em", email).setParameter("pwd", password).getSingleResult();
		return user;
	}
	
}
