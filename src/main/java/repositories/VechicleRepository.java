package repositories;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VechicleRepository {

    private Map<String, Vehicle> vehicleMap = new HashMap<>();

    public Optional<Vehicle> findVehicleByVehicleNo(String vehicleNo){
        if(vehicleMap.containsKey(vehicleNo)){
            return Optional.of(vehicleMap.get(vehicleNo));
        }else{
            return Optional.empty();
        }
    }

    public void save(Vehicle vehicle){
        vehicleMap.put(vehicle.getNo(), vehicle);
    }
}

/*
JPA => Java persistent APIs
JPA interface

ORMs = Hibernate
 */
