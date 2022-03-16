package com.nkama.drone.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.*;

import lombok.Data;

@Entity
@Table(name = "drones")
@Data
public class Drone {
	
	@Id
	@Size(max = 100)
    private String serial;
	
	private String model;
	
	@Column(name="weight")
	private double weight;
	
	@Column(name="battery_capacity")
	private double batteryCapacity;
	
	private int state;
	
	//@OneToMany(mappedBy = "drone")
    //private List<Medication> medications;
	
	
}
