package com.loyalty.service;

import java.util.List;

import com.loyalty.entity.User;

public interface UserService {

	public void persist(User user);
	public void merge(User user);
	public void remove(User user);
	public User findById(Integer userId);
	public User find(User user);
	public List<User> findAll();
	public List<User> findListByCodition(User user);
}
