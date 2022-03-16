package com.nkama.drone.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

import lombok.Data;

@Data
@Entity
@Table(name = "medications")
public class Medication {
	
	@Id
	@Pattern(regexp = "^[A-Z0-9_]+$")
    private String code;
	
	@Pattern(regexp = "^[A-Za-z_-]+$")
	private String name;
	
	private String image;
	
	private double weight;
	
	@ManyToOne
    @JoinColumn(name="drone_id")
    private Drone drone;

}

