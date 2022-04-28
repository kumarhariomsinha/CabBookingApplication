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

import com.interview.thinkify.entities.Driver;
import com.interview.thinkify.entities.User;
import com.interview.thinkify.services.driverServices;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

	@Autowired
	private driverServices driverService;
	//api to get AllDrivers on platform
	@GetMapping("/allDrivers")
	public ResponseEntity<List<Driver>> getDrivers(){
		return ResponseEntity.ok(this.driverService.getAllDrivers());
		
	}
	//api to create new Driver
	@PostMapping("/addDriver")
	public ResponseEntity<Driver>createUser( @RequestBody Driver driver){
		Driver createdDriver =this.driverService.addDriver(driver);
		return new ResponseEntity<>(createdDriver,HttpStatus.CREATED);
	}
	//apit to update driverLocation
	@PutMapping("/{driverName}")
	public  String updateDriverLocation(@RequestBody Driver driver,@PathVariable String driverName){
		Driver driver1 = null;
		try {
		driver1=driverService.findByDriverName(driverName);

		this.driverService.updateDriverLoc(driverName, driver.getX(), driver.getY());
		return "Driver Location Updated!!!!!";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "Error";
	}
}
