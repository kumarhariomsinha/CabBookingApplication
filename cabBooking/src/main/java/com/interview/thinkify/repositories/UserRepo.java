package com.interview.thinkify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.thinkify.entities.Driver;
import com.interview.thinkify.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {

	//public Driver findByDriverName(String driverName);
	public User findByUserName(String userName); 
}
