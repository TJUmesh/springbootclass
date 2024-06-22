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

}
