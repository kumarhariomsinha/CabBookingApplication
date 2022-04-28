package com.interview.thinkify.services;

import java.util.List;

import com.interview.thinkify.entities.Driver;

public interface driverServices {
 
   Driver addDriver(Driver driver);
   List<Driver> getAllDrivers();
 //  Driver findByName(String driverName);
 Driver findByName(String driverName);
  
 Driver findByDriverName(String driverName);

  Driver updateDriverLoc(String driverName, int x, int y);


}
