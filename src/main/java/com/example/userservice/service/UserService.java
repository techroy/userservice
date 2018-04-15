package com.example.userservice.service;

import java.util.List;

import com.example.userservice.entities.User;

public interface UserService {

	public void create(User user);
	
	public List<User> findAll();
	
	public User findById(String id);
	
	public User update(User user);
	
	public void delete(String id);
	
}
