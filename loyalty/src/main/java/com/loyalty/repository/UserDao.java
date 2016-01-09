package com.loyalty.repository;

import java.util.List;

import com.loyalty.entity.User;

public interface UserDao {

	void persist(User user);
	void merge(User user);
	void remove(User user);
	User findById(Integer userId);
	User find(User user);
	List<User> findAll();
	List<User> findListByCodition(User user);
}
