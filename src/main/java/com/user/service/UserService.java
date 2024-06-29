package com.user.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.exception.MisMatchPassword;
import com.user.exception.UserAlreadyExist;
import com.user.exception.UserNotFoundException;
import com.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveDataService(User user) {

		Optional<User> byEmail = userRepository.findByEmail(user.getEmail());

		if (byEmail.isPresent()) {

			throw new UserAlreadyExist("User Already Exist!  " + user.getEmail());
		}

		if (!user.getPassword().equals(user.getRepeatPassword())) {
			throw new MisMatchPassword("Sorry Mismatch Password ");
		}

		User save = this.userRepository.save(user);

		return save;
	}

	// get data by userId
	public User getData(Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User Not Found with Id :" + userId));

	}

	// get All User

	public List<User> getAllData(Pageable pageable) {
		return this.userRepository.findAll();
	}

	// byId data

	public User updateData(User user, Long userId) {
		User byId = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User Not Found with Id :" + userId));

		byId.setFirstName(user.getFirstName());
		byId.setLastName(user.getLastName());
		byId.setAddress(user.getAddress());
		byId.setMobileNo(user.getMobileNo());
		byId.setPassword(user.getPassword());

		return userRepository.save(byId);
	}

	// delete data by Id

	public String deleteData(Long userId) {
		User byId = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User Not Found with Id :" + userId));

		userRepository.delete(byId);
		return "Data SuccussFully Deleted";
	}

	// Fetch Data By Name

	public User fetchData(String name) {
		User byFirstName = userRepository.findByFirstName(name);

		if (Objects.isNull(byFirstName)) {
			throw new UserNotFoundException("User Not Found with name :" + name);
		}
		return byFirstName;
	}

	public User fetchbyAddress(String address) {

		User byAddress = userRepository.findByAddress(address);
		if (Objects.isNull(byAddress)) {
			throw new UserNotFoundException("User Address Not Found " + address);
		}
		return byAddress;
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
