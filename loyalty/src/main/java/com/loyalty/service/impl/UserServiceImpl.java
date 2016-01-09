package com.loyalty.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.loyalty.entity.User;
import com.loyalty.repository.UserDao;
import com.loyalty.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void persist(User user) {
		userDao.persist(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void merge(User user) {
		userDao.merge(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void remove(User user) {
		userDao.remove(user);
	}

	@Override
	public User findById(Integer userId) {
		return userDao.findById(userId);
	}

	@Override
	public User find(User user) {
		return userDao.find(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public List<User> findListByCodition(User user) {
		return userDao.findListByCodition(user);
	}

}
