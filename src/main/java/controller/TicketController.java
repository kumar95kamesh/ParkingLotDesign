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

    public TicketController(TicketService ticketService){//Ticket controller is dependant on ticket service.
        this.ticketService = ticketService;//injecting dependancy... General practice
        //This is constructor now if client has to create a ticket.. he has to use ticket service
        //and here the info provided will be derived by ticket service
    }

    // /ticket/book... So this mtd will be called by frontend to book ticket 
    //Response Entity
    //So ticket will be issued with response Dto
    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO issueTicketRequestDTO){
        IssueTicketResponseDTO issueTicketResponseDTO = new IssueTicketResponseDTO();

        try {//Here the limited info will be provided which will be extracted from request DTO
            Ticket ticket = ticketService.issueTicket(issueTicketRequestDTO.getGateId(),
                    issueTicketRequestDTO.getVehicleNumber(),
                    issueTicketRequestDTO.getVehicleOwnerName(),
                    issueTicketRequestDTO.getVehicleType(),
                    issueTicketRequestDTO.getParkingLotId());
            issueTicketResponseDTO.setTicket(ticket);
            issueTicketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception ex){//is any issue comes set status as failed
            issueTicketResponseDTO.setResponseStatus(ResponseStatus.FAILED);
        }

        return issueTicketResponseDTO;
    }
}
