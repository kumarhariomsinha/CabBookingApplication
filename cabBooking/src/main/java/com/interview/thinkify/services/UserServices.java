package com.interview.thinkify.services;

import java.util.List;

import com.interview.thinkify.entities.Driver;
import com.interview.thinkify.entities.User;

public interface UserServices {

	User createUser(User user);

	List<User> getAllUsers();

	User getUserById(Integer userId);
	
	
	 User findByUserName(String userName);

	

	User updateUser(String userName, int x, int y);
}
