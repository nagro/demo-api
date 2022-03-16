# Spring Boot, JPA, Hibernate Rest API Example for Drone dispatcher controller

A small demo api

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/nagro/demo-api.git
```

**2. How to buid and run**

Build: mvnw clean package

RUN: mvnw spring-boot:run


**3. Usage **

registering a drone: localhost:9000/drone

{
        "serial": "SERIAL",
        "model": "MODEL",
        "weight": 1.0,
        "batteryCapacity": 1.0,
        "state": 0
    }
    
   
 