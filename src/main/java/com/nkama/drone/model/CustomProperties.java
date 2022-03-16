package com.nkama.drone.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "com.nkama.app.drone")
@Data
public class CustomProperties {
	
	private double weight_limit;
	
	private int fleet_limit;
	
	private int IDLE;
	
	private int LOADING;
	
	private int LOADED;
	
	private int DELIVERING;
	
	private int DELIVERED;
	
	private int RETURNING;

}
