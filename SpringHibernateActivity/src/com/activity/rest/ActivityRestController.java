package com.activity.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activity.model.User;
import com.activity.service.UserService;

@RestController
@RequestMapping("/api")
public class ActivityRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> get(){
		
		return userService.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getPresident(@PathVariable int id){
		User theUser = userService.getUser(id);

		if(theUser == null){
			throw new ActivityNotFoundException("User id not found - " + id);
		}
		return theUser;
	}
}
