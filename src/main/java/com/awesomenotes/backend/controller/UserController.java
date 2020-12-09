package com.awesomenotes.backend.controller;

import java.util.List;

import com.awesomenotes.backend.dao.UserDao;
import com.awesomenotes.backend.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDao dao;

	@PostMapping("/register")
	public String register(@RequestBody User user) {

		if(dao.findUserByUsername(user.getUsername()) == null){
			User newUser = dao.save(user);
			return "id: " + newUser.getId();
		} else
			return "error: username already in use";
	}

	@PostMapping("/login")
	public String login(@RequestBody User user) {
		User dbUser = dao.findUserbyCredentials(user.getUsername(), user.getPassword());
		if (dbUser != null) {
			return "id: " + dbUser.getId();
		}
		else return "error: invalid credentials";
	}

	

	@GetMapping("")
	public List<User> getUsers() {
		return (List<User>) dao.findAll();
	}
}