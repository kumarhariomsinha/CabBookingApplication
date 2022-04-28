package com.interview.thinkify.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.thinkify.entities.Driver;
import com.interview.thinkify.entities.User;
import com.interview.thinkify.repositories.UserRepo;

@Service
public class UserServicesImpl implements UserServices {
	@Autowired
	private UserRepo userRepo;
	@Override
    public User createUser(User user) {
    	User u=this.userRepo.save(user);
    	return u;
    }
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				 List<User>users=this.userRepo.findAll();
				return users;
		
	}
	@Override
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId).orElseThrow(()->new com.interview.thinkify.exceptions.ResourceNotFoundException("User","UserId", userId));
		return user;
	}
	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findByUserName(userName);
		return user;
	}
	@Override
	public User updateUser(String userName,int x,int y) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findByUserName(userName);
		user.setX(x);
		user.setY(y);
		userRepo.save(user);
		return user;
	}
	
	

}
