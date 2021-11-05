package com.naveen.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.naveen.security.model.User;
import com.naveen.security.repository.UserRepository;

public class CustomUserDetailsService  implements UserDetailsService{
    @Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =userRepository.findByUsername(username);
		
		if(user==null)
		{
			throw new  UsernameNotFoundException("user name not found");
		}
		return new CustomUserDetails(user);
	}

}
