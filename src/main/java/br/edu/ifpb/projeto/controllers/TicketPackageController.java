package br.edu.ifpb.projeto.controllers;


import br.edu.ifpb.projeto.dtos.BuyPackageDTO;
import br.edu.ifpb.projeto.dtos.BuyTicketDTO;
import br.edu.ifpb.projeto.dtos.PromoTicketDTO;
import br.edu.ifpb.projeto.dtos.TicketPackageDTO;
import br.edu.ifpb.projeto.models.PromoTicket;
import br.edu.ifpb.projeto.models.Ticket;
import br.edu.ifpb.projeto.models.TicketPackage;
import br.edu.ifpb.projeto.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ticket-package")
public class TicketPackageController {


    private final TicketPackageService ticketPackageService;
    private final EventService eventService;
    private final ModalityService modalityService;
    private final EventInfoService eventInfoService;
    private final TicketService ticketService;
    private final PersonService personService;

    public TicketPackageController(TicketPackageService ticketPackageService, EventService eventService, ModalityService modalityService, EventInfoService eventInfoService, TicketService ticketService, PersonService personService) {
        this.ticketPackageService = ticketPackageService;
        this.eventService = eventService;
        this.modalityService = modalityService;
        this.eventInfoService = eventInfoService;
        this.ticketService = ticketService;
        this.personService = personService;
    }

    @PostMapping("/")
    public TicketPackage save(@RequestBody TicketPackageDTO ticketPackageDTO) {
        var ticketPackage = new TicketPackage();
        ticketPackage.setType(ticketPackageDTO.type());
        List<PromoTicket> ticketPackageList = ticketPackageDTO.ticket_list().stream().map((PromoTicketDTO ticket) -> {
            var promoTicket = new PromoTicket();
            var event = eventService.findById(ticket.event_id());
            var eventInfo = eventInfoService.findById(ticket.event_info_id());
            var modality = modalityService.findById(ticket.modality_id());
            promoTicket.setEvent(event);
            promoTicket.setModality(modality);
            promoTicket.setEventDate(eventInfo);
            return promoTicket;
        }).toList();
        ticketPackage.setTicketOptions(ticketPackageList);
        return ticketPackageService.save(ticketPackage);
    }

    @PutMapping("/buy/{id}")
    public ResponseEntity<List<Ticket>> buy(@PathVariable UUID id, @RequestBody BuyPackageDTO buyPackageDTO) {
        var tickets = new ArrayList<Ticket>();
        var personList = buyPackageDTO.ticketsInfo().stream().iterator();
        var ticketPackage = ticketPackageService.findById(id);
        for (var ticketOption: ticketPackage.getTicketOptions()){
            if(!personList.hasNext()) {
                return ResponseEntity.notFound().build();
            }
            var info = personList.next();
            var ticket = this.ticketService.findTicket(ticketOption.getEvent().getId(), ticketOption.getEventDate().getId(), ticketOption.getModality().getId());
            var person = personService.findById(info.owner_id());
            var responses = TicketService.fillTicket(info.fields(), ticketOption.getModality());
            ticket.setOwner(person);
            ticket.setResponseList(responses);
            var savedTicket = this.ticketService.save(ticket);
            tickets.add(savedTicket);
        }

        return ResponseEntity.ok(tickets);
    }
}
