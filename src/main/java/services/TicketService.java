package services;

import exceptions.GateNotFoundException;
import factory.SpotAssignmentFactory;
import models.*;
import models.enums.SpotAssignmentStrategyType;
import models.enums.TicketStatus;
import models.enums.VehicleType;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VechicleRepository;
import strategies.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private VechicleRepository vechicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;


    public TicketService(GateRepository gateRepository,
                         VechicleRepository vechicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository){
        this.gateRepository = gateRepository;
        this.vechicleRepository = vechicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(Long gateId,
                              String vehicleNo,
                              String ownerName,
                              VehicleType vehicleType,
                              Long parkingLotId) throws GateNotFoundException {
        //contain the business logic for generating the ticket
        Ticket ticket = new Ticket();
        ticket.setEntryTime(System.currentTimeMillis()); //epoch

        //checking the gate with the given gateId in the param
        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);

        if(optionalGate.isEmpty()){
            //invalid gateId
            throw new GateNotFoundException("Gate with gateId " + gateId + " is not present in the parking lot");
        }

        Gate gate = optionalGate.get();

        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

        Optional<Vehicle> optionalVehicle =  vechicleRepository.findVehicleByVehicleNo(vehicleNo);

        Vehicle savedVehicle;


        if(optionalVehicle.isEmpty()){
            //vehicle is coming for the first time in your parking lot
            Vehicle vehicle = new Vehicle();
            vehicle.setNo(vehicleNo);
            vehicle.setOwner(ownerName);
            vehicle.setVehicleType(vehicleType);

            vechicleRepository.save(vehicle);
            savedVehicle = vehicle;
        }else{
            savedVehicle = optionalVehicle.get();
        }

        ticket.setVehicle(savedVehicle);
        ticket.setTicketStatus(TicketStatus.VALID);

        //ticketNo could be custom:_ TICKET_1_24bh8352f_Umang_tiemstamp
        ticket.setTicketNo("TICKET_" + gateId + "_" + vehicleNo + "_" + ticket.getGeneratedAt().getOperator().getName());


        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.getParkingLotById(parkingLotId);
        if(optionalParkingLot.isEmpty()){
            throw new RuntimeException("Invalid parking lot id");
        }

        ParkingLot parkingLot = optionalParkingLot.get();

        SpotAssignmentStrategyType spotAssignmentStrategyType = parkingLot.getSpotAssignmentStrategyType();

        //based on the type, get the corresponding algorithm

        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentFactory.getSpotAssignmentStrategy(spotAssignmentStrategyType);

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, gate);

        ticket.setParkingSpot(parkingSpot);

        ticketRepository.save(ticket);

        return ticket;
    }
}
