package com.nkama.drone.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkama.drone.model.Drone;
import com.nkama.drone.repositories.DroneRepository;

import lombok.Data;

@Data
@Service
public class DroneService {
	@Autowired
	private DroneRepository droneRepository;
	
	public Optional<Drone> getDrone(final String serial) {
        return droneRepository.findById(serial);
    }

    public Iterable<Drone> getDrones() {
        return droneRepository.findAll();
    }

    public void deleteDrone(final String serial) {
        droneRepository.deleteById(serial);
    }

    public Drone saveDrone(Drone drone) {
        Drone savedDrone = droneRepository.save(drone);
        return savedDrone;
    }

}
