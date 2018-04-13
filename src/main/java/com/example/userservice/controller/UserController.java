package com.example.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.entities.User;
import com.example.userservice.service.UserService;

//@Controller
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/create")
	public HttpEntity<String> create(@RequestBody User user) {

		System.out.println(user);

		userService.create(user);

		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<String, String>();

		multiValueMap.add("idm", "AxisBank");

		// return new ResponseEntity<String>("created",HttpStatus.CREATED);

		return new ResponseEntity<String>("created", multiValueMap, HttpStatus.CREATED);

	}

	@GetMapping(value = "/findAll")
	public HttpEntity<List<User>> findAll() {

		List<User> users = userService.findAll();

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);

	}

	// @RequestMapping(value="/create",method=RequestMethod.POST)
	/*
	 * @PostMapping(value="/create") public @ResponseBody String
	 * create(@RequestBody User user) {
	 * 
	 * 
	 * System.out.println(user);
	 * 
	 * return "Created";
	 * 
	 * }
	 */

	/*
	 * @PostMapping(value="/create") public @ResponseBody HttpEntity<String>
	 * create(@RequestBody User user) {
	 * 
	 * 
	 * System.out.println(user);
	 * 
	 * 
	 * 
	 * MultiValueMap<String, String> multiValueMap = new
	 * LinkedMultiValueMap<String, String>();
	 * 
	 * multiValueMap.add("idm", "AxisBank");
	 * 
	 * //return new ResponseEntity<String>("created",HttpStatus.CREATED);
	 * 
	 * return new ResponseEntity<String>("created", multiValueMap,
	 * HttpStatus.CREATED);
	 * 
	 * }
	 */

}
