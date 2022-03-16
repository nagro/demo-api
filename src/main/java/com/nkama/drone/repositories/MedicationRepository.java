package com.nkama.drone.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nkama.drone.model.Drone;
import com.nkama.drone.model.Medication;

@Repository
public interface MedicationRepository extends CrudRepository<Medication, String> {

}
