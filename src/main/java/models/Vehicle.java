package models;

import models.enums.VehicleType;

public class Vehicle extends BaseModel{
    private String no;
    private String ownerName;
    private VehicleType vehicleType;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getOwner() {
        return ownerName;
    }

    public void setOwner(String owner) {
        this.ownerName = owner;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
