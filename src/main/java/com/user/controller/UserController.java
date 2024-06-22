package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/postdata")
	public User saveData(@RequestBody User user) {
		User saveDataService = userService.saveDataService(user);
		return saveDataService;
	}

	@GetMapping("/get/{userId}")

	public User getData(@PathVariable Long userId) {
		return userService.getData(userId);
	}

	@GetMapping("/getall")
	public List<User> getAllData() {
		return userService.getAllData();
	}

	//
	@PutMapping("/path/{id}")
	public User updateData(@RequestBody User user,@PathVariable("id") Long userId) {
		return userService.updateData(user, userId);
	}

}
