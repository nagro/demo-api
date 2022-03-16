package com.nkama.drone.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import lombok.Data;

@Data
@Entity
@Table(name = "medications")
public class medication {
	
	@Id
	@Pattern(regexp = "^[A-Z0-9_]+$")
    private String code;
	
	@Pattern(regexp = "^[A-Za-z_-]+$")
	private String name;
	
	private String image;
	
	private double weight;

}

