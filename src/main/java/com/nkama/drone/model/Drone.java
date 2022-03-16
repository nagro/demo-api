package com.nkama.drone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import lombok.Data;

@Data
@Entity
@Table(name = "drones")

public class Drone {
	
	@Id
	@Size(max = 6)
    private String serial;
	
	private String model;
	
	@Column(name="weight")
	private double weight;
	
	@Column(name="battery_capacity")
	private double batteryCapacity;
	
	private int state;
	
	
}
