package br.edu.ifpb.projeto.controllers;


import br.edu.ifpb.projeto.dtos.BuyTicketDTO;
import br.edu.ifpb.projeto.dtos.TicketDTO;
import br.edu.ifpb.projeto.models.FieldResponse;
import br.edu.ifpb.projeto.models.Ticket;
import br.edu.ifpb.projeto.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private final TicketService ticketService;
    private final EventInfoService eventInfoService;
    private final EventService eventService;
    private final PersonService personService;
    private final FieldService fieldService;
    private final FieldResponseService fieldResponseService;
    private final ModalityService modalityService;


    public TicketController(TicketService ticketService, EventInfoService eventInfoService, EventService eventService, PersonService personService, FieldResponseService fieldResponseService, FieldService fieldService, ModalityService modalityService) {
        this.ticketService = ticketService;
        this.eventInfoService = eventInfoService;
        this.eventService = eventService;
        this.personService = personService;
        this.fieldResponseService = fieldResponseService;
        this.fieldService = fieldService;
        this.modalityService = modalityService;
    }

    @PostMapping("/")
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketDTO ticketDTO) {
        var eventInfo = eventInfoService.findById(ticketDTO.eventInfoID());
        var event = eventService.findById(ticketDTO.eventId());
        var modality = modalityService.findById(ticketDTO.modalityId());
        var ticket = new Ticket();
        var responses = new ArrayList<FieldResponse>();
        ticket.setEvent(event);
        ticket.setEventDate(eventInfo);
        ticket.setModality(modality);
        ticket.setResponseList(responses);
        var ticketResponse = ticketService.save(ticket);

        return new ResponseEntity<>(ticketResponse,HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Ticket> buyTicket(@PathVariable("id") UUID id, @RequestBody BuyTicketDTO buyTicketDTO) {

        var person = personService.findById(buyTicketDTO.owner_id());
        var ticket = ticketService.findById(id);
        var responses = TicketService.fillTicket(buyTicketDTO.fields(), ticket.getModality());
        ticket.setOwner(person);
        ticket.setId(id);
        ticket.setResponseList(responses);
        var ticketResponse = ticketService.save(ticket);

        return new ResponseEntity<>(ticketResponse,HttpStatus.OK);

    }

}
