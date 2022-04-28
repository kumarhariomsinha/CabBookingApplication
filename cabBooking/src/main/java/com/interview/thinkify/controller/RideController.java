package com.interview.thinkify.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.thinkify.dto.AvailableDriver;
import com.interview.thinkify.dto.RideDetails;
import com.interview.thinkify.dto.chooseRides;
import com.interview.thinkify.dto.findRide;
import com.interview.thinkify.entities.Driver;
import com.interview.thinkify.entities.User;
import com.interview.thinkify.repositories.RideDetailsRepo;
import com.interview.thinkify.repositories.driverRepo;
import com.interview.thinkify.services.RideDetailsServiceRepo;
import com.interview.thinkify.services.driverServices;

@RestController
@RequestMapping("/api/bookride")
public class RideController {

	@Autowired
	private driverServices driverServices;
//	
	@Autowired
	private RideDetailsRepo rideDetailsRepo;
	
	//api to find drivers for ride
	@PostMapping("/")
	public List<AvailableDriver>findRides( @RequestBody findRide bookRide){
		List<Driver> drivers=this.driverServices.getAllDrivers();
		List<AvailableDriver> availDriver=new ArrayList<>();
		for(int i=0;i<drivers.size();i++) {
			int x= drivers.get(i).getX();
			int y=drivers.get(i).getY();
			
		  long a= Math.abs(x-bookRide.getSourceX());
		  long b=Math.abs(y-bookRide.getSourceY());
		 
			
		  
			double distance=Math.sqrt(a*a+b*b);
			if(distance<=5) {
				AvailableDriver driver=new AvailableDriver(drivers.get(i).getDriverName(),drivers.get(i).isStatus());
				availDriver.add(driver);
			   RideDetails currRide=new RideDetails();
			   currRide.setDriverName(drivers.get(i).getDriverName());
			   currRide.setUsername(bookRide.getUserName());
			 
			   currRide.setSourceX(bookRide.getSourceX());
			   currRide.setSourceY(bookRide.getSourceY());
			   currRide.setDestinationX(bookRide.getDestinationX());
			   currRide.setDestinationY(bookRide.getDestinationY());
			   currRide.setStatus(false);
			   
			  this.rideDetailsRepo.save(currRide);
			  
			}
			
		}
		return availDriver;
	}
	
	//api to choose drivers and calculate bill from available list
	@PostMapping("/chooseRide/{userName}/{driverName}")
	public String chooseRides(@PathVariable String userName, @PathVariable String driverName){
	
		Driver availDriver;
		try {
		
			availDriver=driverServices.findByDriverName(driverName);
			if(availDriver==null) {
				return "Driver not found";
			}
			availDriver.setStatus(false);
			
			List<RideDetails> ridedetails=this.rideDetailsRepo.findAll();
			System.out.println("RideDetails are "+ridedetails);
			for(int i=0;i<ridedetails.size();i++) {
				if(ridedetails.get(i).getDriverName()==driverName&& ridedetails.get(i).getUsername()==userName)
				{
					ridedetails.get(i).setStatus(true);
					long sourceX=ridedetails.get(i).getSourceX();
					long sourceY=ridedetails.get(i).getSourceY();
					
					long destinationX=ridedetails.get(i).getDestinationX();
					long destinationY=ridedetails.get(i).getDestinationY();
					
					long l= Math.abs(sourceX-destinationX);
					long m=Math.abs(sourceY-destinationY);
					
					double distance=Math.sqrt(l*l+m*m);
			        double TotalBill=distance*2;
			        ridedetails.get(i).setDistance(distance);
			        ridedetails.get(i).setTotalBill(TotalBill);
			        //Total Bill 
			        System.out.println("TotalBill is"+TotalBill);
			        break;
				}
			}
		
		return "Ride Started";
		} catch(Exception e) {
			e.printStackTrace();
		}
		  
		
		return "Error!!!!";
	}
	
	
	
	
}
