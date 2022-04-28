package com.interview.thinkify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.thinkify.dto.RideDetails;


public interface RideDetailsRepo extends JpaRepository<RideDetails,Integer> {

	//public RideDetails saveRideDetails(RideDetails rideDetails);

}
