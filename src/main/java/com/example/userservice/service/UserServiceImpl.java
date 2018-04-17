package com.example.userservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userservice.entities.User;
import com.example.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Override
	public void create(User user) {

		userRepository.save(user);

	}

	@Override
	public List<User> findAll() {

		Iterable<User> userIterator = userRepository.findAll();

		List<User> userList = new ArrayList<User>();

		Iterator it = userIterator.iterator();

		while (it.hasNext()) {

			userList.add((User) it.next());
		}

		return userList;

	}

	@Override
	public User findById(String id) {

		return userRepository.findOne(Integer.parseInt(id));
	}

	@Transactional
	@Override
	public User update(User user) {

		return userRepository.save(user);

	}

	@Transactional
	@Override
	public void delete(String id) {

		userRepository.delete(Integer.parseInt(id));

	}

	@Override
	public User finUserByName(String name) {
		
		return userRepository.findByNameAndEmail(name,"adam1@gmail.com");
	}
	
	

}
