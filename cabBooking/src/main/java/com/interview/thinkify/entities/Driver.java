package com.interview.thinkify.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="driver")
@NoArgsConstructor
@Getter
@Setter
public class Driver {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	@Column(name="driverName", nullable=false,length=100)
    private String driverName;
    private String sex;
    private int age;
    private String vehicle_name;
    private long vehicle_number;
    private int x;
    private int y;
    private boolean status;
}
