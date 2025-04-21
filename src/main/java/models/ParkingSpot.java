package models;

import models.enums.ParkingSpotStatus;
import models.enums.VehicleType;

public class ParkingSpot extends BaseModel{
    private ParkingSpotStatus parkingSpotStatus;
    private ParkingFloor parkingFloor; //optional, fast retrieval
    private int spotNo; //spotNo = 3
    //parking_spot_id = different
    private VehicleType vehicleType;


    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public int getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(int spotNo) {
        this.spotNo = spotNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}

/*
PF PS => 1 : M
1   M
1   1

No redundancy in data storage
 */