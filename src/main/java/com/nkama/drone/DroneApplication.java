package com.nkama.drone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DroneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DroneApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
        System.out.println("App started");
    }

	

}
