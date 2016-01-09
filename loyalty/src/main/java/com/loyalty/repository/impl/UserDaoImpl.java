package com.loyalty.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.loyalty.entity.User;
import com.loyalty.repository.UserDao;

@Repository
public class UserDaoImpl implements UserDao  {
	
	private EntityManager em;
	String sqlQuery="";
	

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public void persist(User user) {
		em.persist(user);
	}

	@Override
	public void merge(User user) {
		em.merge(user);
	}

	@Override
	public void remove(User user) {
		user.setActiveFlg(false);
		em.merge(user);
	}

	@Override
	public User findById(Integer userId) {
		sqlQuery = "select x from User x where x.userId= :userId and x.activeFlg = 1";
		return (User) em.createQuery(sqlQuery).setParameter("userId", userId).getSingleResult();
	}

	@Override
	public User find(User user) {
		sqlQuery = "select x from User x where x.userId= :userId and x.activeFlg = 1";
		return (User) em.createQuery(sqlQuery).setParameter("userId", user.getUserId()).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		sqlQuery = "select x from User x where x.activeFlg = 1 ORDER BY x.userId DESC ";
        return em.createQuery(sqlQuery).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findListByCodition(User user) {
		sqlQuery = "select * from user where 1=1 ";
		
		if(StringUtils.isNotBlank(user.getLogin())){
			sqlQuery = sqlQuery+" AND login = '"+user.getLogin()+"' ";
		}
		
		sqlQuery = sqlQuery+" order by userId DESC";
        return em.createNativeQuery(sqlQuery,User.class).getResultList();
	}
}
