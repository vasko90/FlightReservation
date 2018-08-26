package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User saveUser(User user) {
		User u = null;
		List<User>users = getAllUsers();
		int i = 0;
		for(User us : users) {
			if(user.getEmail().equals(us.getEmail())) {
				i++;
			}
		}
		if(i == 0) {
			u = userRepository.saveAndFlush(user);
		}
		
		return u;
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	

	
}
