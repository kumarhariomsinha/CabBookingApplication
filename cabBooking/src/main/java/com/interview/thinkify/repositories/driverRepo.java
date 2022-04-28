package com.interview.thinkify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.thinkify.entities.Driver;


public interface driverRepo extends JpaRepository<Driver,Integer>{

	public Driver findByDriverName(String driverName);
}
