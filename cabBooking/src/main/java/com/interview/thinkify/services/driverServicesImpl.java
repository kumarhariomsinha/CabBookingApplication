package com.interview.thinkify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.thinkify.entities.Driver;
import com.interview.thinkify.entities.User;
import com.interview.thinkify.repositories.driverRepo;

@Service
public class driverServicesImpl implements driverServices {

	@Autowired
	private driverRepo driverRepos;
	
	@Override
	public Driver addDriver(Driver driver) {
		// TODO Auto-generated method stub
		Driver dr=this.driverRepos.save(driver);
		return dr;
	}

	@Override
	public List<Driver> getAllDrivers() {
		// TODO Auto-generated method stub
		
		return this.driverRepos.findAll();
	}

	@Override
	public Driver findByName(String driverName) {
		// TODO Auto-generated method stub
//		return this.driverRepos.findById(null)

		return null;
	}

	@Override
	public Driver findByDriverName(String driverName) {
		// TODO Auto-generated method 

		return this.driverRepos.findByDriverName(driverName);
	}

	@Override
	public Driver updateDriverLoc(String driverName, int x, int y) {
		// TODO Auto-generated method stub
		Driver driver=this.driverRepos.findByDriverName(driverName);
		driver.setX(x);
		driver.setY(y);
		driverRepos.save(driver);
		
		return driver;
	}

}
