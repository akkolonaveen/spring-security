package com.naveen.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naveen.security.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

	User findByUsername(String username);

}
