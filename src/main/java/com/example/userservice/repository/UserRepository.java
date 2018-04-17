package com.example.userservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.userservice.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByName(String name);

	public User findByNameAndEmail(String name, String email);
	
//	@Query("from User where name=?")
	//public User fetchName(String name);
}
