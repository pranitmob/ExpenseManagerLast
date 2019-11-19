package com.app.ExpenseManagerLast.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.app.ExpenseManagerLast.model.categoryModel;

@Repository
@Transactional
public class CategoryDaoImpl implements ICategoryDao {

	@PersistenceContext
	private EntityManager entitytManager;
	
	@Override
	public List<categoryModel> getAllCategories() {
		CriteriaBuilder criteriaBuilder = entitytManager.getCriteriaBuilder();
		CriteriaQuery<categoryModel> crietriaQuery = criteriaBuilder.createQuery(categoryModel.class);
		Root<categoryModel> root = crietriaQuery.from(categoryModel.class);
		crietriaQuery.select(root);
//		String jpql = "select c from categoryModel c";
		return entitytManager.createQuery(crietriaQuery).getResultList();
	}
	
	
}
