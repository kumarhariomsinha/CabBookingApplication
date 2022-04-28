package com.interview.thinkify.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.interview.thinkify.dto.RideDetails;
import com.interview.thinkify.repositories.RideDetailsRepo;



@Service
public class RideDetailsServiceRepoImpl implements RideDetailsServiceRepo {

	@Autowired
	private RideDetailsRepo rideDetailsRepo;

//	@Override
//	public RideDetails saveRideDetails(RideDetails rideDetails) {
//		// TODO Auto-generated method stub
//	   RideDetails r=	this.rideDetailsRepo.save(rideDetails);
//		
//	   return r;
//		
//	}

	@Override
	public List<RideDetails> findAllRideDetails() {
		// TODO Auto-generated method stub
		return this.rideDetailsRepo.findAll();
	}


	
	
}
