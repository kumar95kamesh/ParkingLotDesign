package repositories;

import models.ParkingSpot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSpotRepository {
    private Map<Long, ParkingSpot> parkingSpotMap = new HashMap<>();

    List<ParkingSpot> getAllParkingSpots(){
        return (List<ParkingSpot>) parkingSpotMap.values();
    }

}
