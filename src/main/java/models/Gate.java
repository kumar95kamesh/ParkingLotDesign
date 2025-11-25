package models;

import models.enums.GateStatus;
import models.enums.GateType;

public class Gate extends BaseModel{
    private int gateNo;
    private Operator operator;
    private GateType gateType;
    private GateStatus gateStatus;
    private ParkingFloor parkingFloor;//based on cardinality we put it here

    //parking floor parking gate
    //PF PG => 1 : M
    //1   M
      // 1     1

    public int getGateNo() {
        return gateNo;
    }

    public void setGateNo(int gateNo) {
        this.gateNo = gateNo;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}

/*
Gate gate = new Gate();
gate.id
gate.createdAt
gate.lastModifiedAt
gate.gateType
gate.operator

Gate() ---- BaseModel()
 */
