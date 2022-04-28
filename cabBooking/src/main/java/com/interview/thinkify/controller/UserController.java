package com.interview.thinkify.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.thinkify.entities.User;
import com.interview.thinkify.services.UserServices;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserServices userService;
	

	//api to create User or Register him/her
@PostMapping("/")
public ResponseEntity<User>createUser( @RequestBody User user){
	User createdUser =this.userService.createUser(user);
	return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
}
//api to get all Users on platform
@GetMapping("/allUsers")
public ResponseEntity<List<User>> getUsers(){
	return ResponseEntity.ok(this.userService.getAllUsers());
	
}
//api to get specific user
@GetMapping("/{userId}")
public ResponseEntity<User> getSingleUsers(@PathVariable Integer userId){
	return ResponseEntity.ok(this.userService.getUserById(userId));
	
}
//api to updateUserLocation
@PutMapping("/{userName}")
public  String updateUserLocation(@RequestBody User user,@PathVariable String userName){
	User user1 = null;
	try {
	user1=userService.findByUserName(userName);

	this.userService.updateUser(userName,user.getX(),user.getY());
	return "User Location Updated!!!!!";
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return "Error";
}
}
