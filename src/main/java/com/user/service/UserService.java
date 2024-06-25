package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.expetion.ResourceNotFoundException;
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
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
	}

	// get All User

	public List<User> getAllData(Pageable pageable) {
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
		User byId = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		userRepository.delete(byId);
		return "Data SuccussFully Deleted";
	}

	// Fetch Data By Name

	public User fetchData(String name) {
		return userRepository.findByFirstName(name);
	}

	public User fetchbyAddress(String address) {
		return userRepository.findByAddress(address);
	}

	// Fetch All By Address
	public List<User> fetchAllByAddress(String address, Pageable pageable) {
		return userRepository.findByAddress(address, pageable);
	}

	// fetch By FirstName And Last Name

	public User fetchByFNameAndLname(String fName, String lName) {
		return userRepository.findByFirstNameAndLastName(fName, lName);

	}

	public Page<User> fechDataWithPagination(Pageable pageable) {
		Page<User> pages = userRepository.findAll(pageable);
		return pages;
	}

}
