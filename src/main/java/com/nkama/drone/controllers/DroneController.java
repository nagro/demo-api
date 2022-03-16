package com.nkama.drone.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nkama.drone.model.CustomProperties;
import com.nkama.drone.model.Drone;
import com.nkama.drone.model.Medication;
import com.nkama.drone.repositories.DroneRepository;
import com.nkama.drone.repositories.MedicationRepository;
import com.nkama.drone.service.DroneService;
import com.nkama.drone.service.MedicationService;

import lombok.Lombok;


@RestController
public class DroneController {
	
	@Autowired
	private DroneService droneService;
	
	@Autowired
	private MedicationService medicationService;
	
	@Autowired
    private CustomProperties properties;
	
	@Autowired
	DroneRepository droneRepository;
	
	@Autowired
	private MedicationRepository medicationRepository;
	
	  /**
	    * Read - Get all drones
	    * @return - An Iterable object of Drones full filled
	  */
	    @GetMapping("/drones")
	    public Iterable<Drone> getAllDrones() {
	        return droneService.getDrones();
	  }
	    
	    /**
		    * Read - Get all medications
		    * @return - An Iterable object of Medication full filled
		  */
		    @GetMapping("/medications")
		    public Iterable<Medication> getAllMedications() {
		        return medicationService.getMedications();
		  }
	    
	    /**
		    * Save - Register a drone
		    * @return - An object Drone saved
		 */
	    @PostMapping("/drone")
		public Drone registerDrone(@RequestBody Drone drone) {
			return droneService.saveDrone(drone);
		}
	    
	    
	    @GetMapping("/drone/{id}")
	    public Drone getDroneById(@PathVariable("id") String id) throws Exception {
	      Drone drone = droneService.getDrone(id).orElseThrow(() -> new Exception("Not found Drone with serial = " + id));
	      return drone;
	    }
	    
	    
	    @PutMapping("/drones/{id}")
	    public Drone updateDrone(@PathVariable("id") String id, @RequestBody Drone drone) throws Exception {
	      Drone tmpDrone = droneService.getDrone(id)
	          .orElseThrow(() -> new Exception("Not found Drone with serial = " + id));
	      tmpDrone.setWeight(drone.getWeight());
	      tmpDrone.setBatteryCapacity(drone.getBatteryCapacity());
	      tmpDrone.setState(drone.getState());
	      //tmpDrone.setMedications(drone.getMedications());
	      
	      return droneService.saveDrone(tmpDrone);
	    }
	    
	    
	    @DeleteMapping("/drones/{id}")
	    public ResponseEntity<HttpStatus> deleteDrone(@PathVariable("id") String id) {
	      droneService.deleteDrone(id);
	      
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    
	    @GetMapping("/drones/loading")
	    public ResponseEntity<List<Drone>> findByloading() {
	    	//get drones with state less than loaded
	      List<Drone> drones = droneRepository.findByStateLessThan(properties.getLOADED());
	      if (drones.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      
	      return new ResponseEntity<>(drones, HttpStatus.OK);
	    }
	    
	    
	    /** load a drone with medications items 
	     * 
	     * @return  An object Drone saved
	     */
	    @PostMapping("/load/{id}")
	    public Medication loadDrone(@PathVariable("id") String id, @RequestBody Medication item) throws Exception {
		      Medication addedMedication = droneRepository.findById(id).map(droneElmt -> {
		          
		         if(droneElmt.getWeight() + item.getWeight() < properties.getWeight_limit()) {
		        	 droneElmt.setWeight(droneElmt.getWeight() + item.getWeight());
		        	 item.setDrone(droneElmt);
		         }
		         //droneService.saveDrone(droneElmt);
		          return medicationRepository.save(item);
		        })
		          .orElseThrow(() -> new Exception("Not found Drone with serial = " + id));
		      
		      return addedMedication;
		    }
	    
	    
	    /** checking loaded medication items for a given drone 
	     * @return An Iterable list of Drones 
	     */
	    
	    @GetMapping("/drone/medications/{id}")
	    public ResponseEntity<List<Medication>> checkMedications(@PathVariable("id") String id) {
	    	//get drones with state less than loaded
	      List<Medication> medications = medicationRepository.findByDroneSerial(id);
	      if (medications.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      
	      return new ResponseEntity<>(medications, HttpStatus.OK);
	    }

	    
	    /** check drone battery level for a given drone
	     * @return the battery level of the drone
	     * @throws Exception 
	     */
	    
	    @GetMapping("/drone/battery/{id}")
	    public double checkBatteryLevel(@PathVariable("id") String id) throws Exception {
	    	Drone drone = droneService.getDrone(id).orElseThrow(() -> new Exception("Not found Drone with serial = " + id));
		      return drone.getBatteryCapacity();
	    	
	    }
	    

}
