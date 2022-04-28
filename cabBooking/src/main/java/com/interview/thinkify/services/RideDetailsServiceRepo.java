package com.interview.thinkify.services;

import java.util.List;

import com.interview.thinkify.dto.RideDetails;

public interface RideDetailsServiceRepo {

	//RideDetails createRideDetails(RideDetails rideDetails);

	// RideDetails saveRideDetails(RideDetails rideDetails);
	 List<RideDetails> findAllRideDetails();
}
