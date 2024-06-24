package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public User updateData(@RequestBody User user, @PathVariable("id") Long userId) {
		return userService.updateData(user, userId);
	}

	// delete Data

	@DeleteMapping("/{userId}")
	public String deleteData(@PathVariable Long userId) {
		return userService.deleteData(userId);
	}

	// by Request Param
	@DeleteMapping("/delete")
	public String deleteUser(@RequestParam Long userId) {
		return userService.deleteData(userId);
	}

	// Fetch Data By Name

	@GetMapping("/name")
	public User findByName(@RequestParam String name) {
		return userService.fetchData(name);
	}

//	@GetMapping("/address")
//	public User findByAddress(@RequestParam String address) {
//		return userService.fetchbyAddress(address);
//	}

	@GetMapping("/byaddress")
	public List<User> findAllByAddress(@RequestParam String address) {

		return userService.fetchAllByAddress(address);
	}

	@GetMapping("/fnamelname")
	public User findByfNamelName(@RequestParam String fName,@RequestParam String lName) {
		return userService.fetchByFNameAndLname(fName, lName);
	}

}
