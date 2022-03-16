package com.nkama.drone.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	    * Read - Get all drones
	    * @return - An Iterable object of Drones full filled
	  */
	    @GetMapping("/drones")
	    public Iterable<Drone> getDrones() {
	        return droneService.getDrones();
	  }
	    
	    /**
		    * Save - Register a drone
		    * @return - An object Drone saved
		 */
	    @PostMapping("/drone")
		public Drone registerDrone(@RequestBody Drone drone) {
			return droneService.saveDrone(drone);
		}
	    
	    
	    
	    

}
