package com.nkama.drone.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nkama.drone.model.CustomProperties;
import com.nkama.drone.model.Drone;
import com.nkama.drone.service.DroneService;

@RestController
public class DroneController {
	
	@Autowired
	private DroneService droneService;
	
	@Autowired
    private CustomProperties properties;
	
	  /**
	    * Read - Get all employees
	    * @return - An Iterable object of Employee full filled
	  */
	    @GetMapping("/drones")
	    public Iterable<Drone> getDrones() {
	        return droneService.getDrones();
	  }

}
