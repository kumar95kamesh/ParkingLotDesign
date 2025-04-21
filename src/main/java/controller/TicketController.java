package controller;

import dtos.IssueTicketRequestDTO;
import dtos.IssueTicketResponseDTO;
import dtos.ResponseStatus;
import models.Ticket;
import services.TicketService;

public class TicketController {
    //responsible for issuing tickets to visitors
    //end to end ws -> should be able to generate a ticket object in the database
    //functionalities

    //issueTicket() - implement in next class


    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    // /ticket/book
    //Response Entity
    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO issueTicketRequestDTO){
        IssueTicketResponseDTO issueTicketResponseDTO = new IssueTicketResponseDTO();

        try {
            Ticket ticket = ticketService.issueTicket(issueTicketRequestDTO.getGateId(),
                    issueTicketRequestDTO.getVehicleNumber(),
                    issueTicketRequestDTO.getVehicleOwnerName(),
                    issueTicketRequestDTO.getVehicleType(),
                    issueTicketRequestDTO.getParkingLotId());
            issueTicketResponseDTO.setTicket(ticket);
            issueTicketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception ex){
            issueTicketResponseDTO.setResponseStatus(ResponseStatus.FAILED);
        }

        return issueTicketResponseDTO;
    }
}
