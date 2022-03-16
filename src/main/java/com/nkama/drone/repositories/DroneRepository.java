package com.nkama.drone.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nkama.drone.model.Drone;

@Repository
public interface DroneRepository extends CrudRepository<Drone, String> {

}
