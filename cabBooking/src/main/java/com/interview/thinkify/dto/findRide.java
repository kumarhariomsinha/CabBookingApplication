package com.interview.thinkify.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class findRide{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rideId;
	private String userName;
	private long sourceX;
	private long sourceY;
	private long destinationX;
	private long destinationY;
	
}
