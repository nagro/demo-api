package com.nkama.drone.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkama.drone.model.Drone;
import com.nkama.drone.model.Medication;
//import com.nkama.drone.repositories.DroneRepository;
import com.nkama.drone.repositories.MedicationRepository;

import lombok.Data;

@Data
@Service
public class MedicationService {
	@Autowired
	private MedicationRepository medicationRepository;
	
	public Optional<Medication> getMedication(final String code) {
        return medicationRepository.findById(code);
    }

    public Iterable<Medication> getMedications() {
        return medicationRepository.findAll();
    }

    public void deleteMedication(final String code) {
        medicationRepository.deleteById(code);
    }

    public Medication saveMedication(Medication medication) {
        Medication savedMedication = medicationRepository.save(medication);
        return savedMedication;
    }

}
