import controller.TicketController;
import dtos.IssueTicketRequestDTO;
import dtos.IssueTicketResponseDTO;
import models.enums.VehicleType;
import repositories.*;
import services.TicketService;

public class Client {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

        TicketRepository ticketRepository = new TicketRepository();

        VechicleRepository vechicleRepository = new VechicleRepository();

        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

        TicketService ticketService = new TicketService(gateRepository,
                vechicleRepository,
                parkingLotRepository,
                ticketRepository);

        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDTO issueTicketRequestDTO = new IssueTicketRequestDTO();
        issueTicketRequestDTO.setVehicleOwnerName("Umang");
        issueTicketRequestDTO.setVehicleNumber("24BH8352F");
        issueTicketRequestDTO.setVehicleType(VehicleType.SUV);
        issueTicketRequestDTO.setParkingLotId(1L);
        issueTicketRequestDTO.setGateId(20L);


        IssueTicketResponseDTO issueTicketResponseDTO = ticketController.issueTicket(issueTicketRequestDTO);

        System.out.println(issueTicketResponseDTO.getResponseStatus());

    }
}
