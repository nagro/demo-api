package com.nkama.drone.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.nkama.drone.model.Drone;

@Service
public class LogginService {
	@Autowired
	private DroneService droneService;

		  @Scheduled(cron="0 */5 * * * ?")
		  public void checkBatteryTask()
		  {
			System.out.println(" :::::::::::::::::::::::::::::::::::::::::::: ");
		    System.out.println("System report :: "+ new Date());
		    
		    for(Drone drone: droneService.getDrones()){
		    	System.out.println(drone.getSerial() + " - battery level: " + drone.getBatteryCapacity());
		    }
		  }
		
}
