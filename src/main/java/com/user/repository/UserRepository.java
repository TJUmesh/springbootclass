package com.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByFirstName(String fname);

	public User findByAddress(String address);

	public List<User> findByAddress(String address, Pageable pageable);

	public User findByFirstNameAndLastName(String fName, String lName);

	public Optional<User> findByEmail(String email);

}
