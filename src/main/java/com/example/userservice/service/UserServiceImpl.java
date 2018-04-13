package com.example.userservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.userservice.entities.User;

@Service
public class UserServiceImpl implements UserService {

	HashMap<Integer, User> memory = new HashMap<Integer, User>();

	@Override
	public void create(User user) {

		memory.put(user.getUserId(), user);

	}

	@Override
	public List<User> findAll() {

		Set<Integer> keySet = memory.keySet();

		List<User> userList = new ArrayList<User>();

		Iterator<Integer> it = keySet.iterator();

		while (it.hasNext()) {

			int key = it.next();

			User user = memory.get(key);

			userList.add(user);

		}

		return userList;

	}

}
