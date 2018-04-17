package com.example.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.entities.User;
import com.example.userservice.service.UserService;

//@Controller
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
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

	@GetMapping(value = "/find")
	public HttpEntity<User> findById(@RequestParam(name = "eid", defaultValue = "1") String id,
			@RequestParam(name = "ename", defaultValue = "max") String ename) {

		System.out.println("Ename--" + ename);

		User user = userService.findById(id);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping(value = "/findPath/{eid}",produces={MediaType.APPLICATION_JSON_VALUE})
	public HttpEntity<User> findByPathId(@PathVariable(name = "eid", required = false) String id) {

		if (id == null) {
			id = String.valueOf(2);
		}

		User user = userService.findById(id);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/findPathName/{name}",produces={MediaType.APPLICATION_JSON_VALUE})
	public HttpEntity<User> findByPathName(@PathVariable(name = "name", required = false) String name) {

		
		User user = userService.finUserByName(name);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	

	@PutMapping(value = "/update",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<User> update(@RequestBody User user) {

		user = userService.update(user);

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
	
	@DeleteMapping(value = "/delete/{eid}",produces=MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Void> delete(@PathVariable String eid) {

		userService.delete(eid);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

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
