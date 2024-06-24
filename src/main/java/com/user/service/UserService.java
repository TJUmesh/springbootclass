package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired

	// insert data
	private UserRepository userRepository;

	public User saveDataService(User user) {

		User save = userRepository.save(user);

		return save;
	}

	// get data by userId
	public User getData(Long userId) {
		return userRepository.findById(userId).get();
	}

	// get All User

	public List<User> getAllData() {
		return userRepository.findAll();
	}

	// byId data

	public User updateData(User user, Long userId) {
		User byId = userRepository.findById(userId).get();

		byId.setFirstName(user.getFirstName());
		byId.setLastName(user.getLastName());
		byId.setAddress(user.getAddress());
		byId.setMobileNo(user.getMobileNo());

		return userRepository.save(byId);
	}

	// delete data by Id

	public String deleteData(Long userId) {
		User byId = userRepository.findById(userId).get();
		userRepository.delete(byId);
		return "Data SuccussFully Deleted";
	}

	// Fetch Data By Name

	public User fetchData(String name) {
		return userRepository.findByFirstName(name);
	}

//	public User fetchbyAddress(String address) {
//		return userRepository.findByAddress(address);
//	}

	// Fetch All By Address
	public List<User> fetchAllByAddress(String address) {
		return userRepository.findByAddress(address);
	}

	// fetch By FirstName And Last Name

	public User fetchByFNameAndLname(String fName, String lName) {
		return userRepository.findByFirstNameAndLastName(fName, lName);
	}

}
