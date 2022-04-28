package com.interview.thinkify.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RideDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int rideId;
	private String username;
	private String driverName;
	private long sourceX;
	private long sourceY;
	private long destinationX;
	private long destinationY;
	double distance;
	double totalBill;
	private boolean status;
	
}
