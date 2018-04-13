package com.example.userservice.service;

import java.util.List;

import com.example.userservice.entities.User;

public interface UserService {

	public void create(User user);
	
	public List<User> findAll();
	
}
