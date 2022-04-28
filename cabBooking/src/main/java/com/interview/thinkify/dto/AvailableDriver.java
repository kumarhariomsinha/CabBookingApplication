package com.interview.thinkify.dto;

import com.interview.thinkify.entities.Driver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDriver {

	private String driverName;

	private boolean status;
}
