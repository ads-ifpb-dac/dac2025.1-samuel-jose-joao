package br.edu.ifpb.projeto.controllers;


import br.edu.ifpb.projeto.dtos.TicketDTO;
import br.edu.ifpb.projeto.models.Ticket;
import br.edu.ifpb.projeto.services.*;
import br.edu.ifpb.projeto.utils.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private final TicketService ticketService;
    private final EventInfoService eventInfoService;
    private final EventService eventService;
    private final PersonService personService;
    private final FieldResponseService fieldResponseService;


    public TicketController(TicketService ticketService, EventInfoService eventInfoService, EventService eventService, PersonService personService, FieldResponseService fieldResponseService) {
        this.ticketService = ticketService;
        this.eventInfoService = eventInfoService;
        this.eventService = eventService;
        this.personService = personService;
        this.fieldResponseService = fieldResponseService;
    }

    /*
    @PostMapping("/")
    public void createTicket(@RequestBody TicketDTO ticketDTO) {
        var person = personService.findById(ticketDTO.owneriD());
        var eventInfo = eventInfoService.findById(ticketDTO.eventId());
        var event = eventService.findById(ticketDTO.eventId());
    }*/

}
