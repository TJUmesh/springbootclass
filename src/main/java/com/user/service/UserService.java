package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired

	private UserRepository userRepository;

	public User saveDataService(User user) {

		User save = userRepository.save(user);

		return save;
	}

}
