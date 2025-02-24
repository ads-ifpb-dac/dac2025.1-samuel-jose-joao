package br.edu.ifpb.projeto.controllers;


import br.edu.ifpb.projeto.dtos.BuyPackageDTO;
import br.edu.ifpb.projeto.dtos.TicketPackageDTO;
import br.edu.ifpb.projeto.models.Ticket;
import br.edu.ifpb.projeto.models.TicketPackage;
import br.edu.ifpb.projeto.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/ticket-package")
public class TicketPackageController {

    private final TicketPackageService ticketPackageService;
    private final TicketService ticketService;
    private final PersonService personService;

    public TicketPackageController(TicketPackageService ticketPackageService, TicketService ticketService, PersonService personService) {
        this.ticketPackageService = ticketPackageService;
        this.ticketService = ticketService;
        this.personService = personService;
    }

    @PostMapping("/")
    public TicketPackage save(@RequestBody TicketPackageDTO ticketPackageDTO) {
        return ticketPackageService.save(ticketPackageDTO);
    }

    @PutMapping("/buy/{id}")
    public ResponseEntity<List<Ticket>> buy(@PathVariable UUID id, @RequestBody BuyPackageDTO buyPackageDTO) {
        var tickets = new ArrayList<Ticket>();
        var personList = buyPackageDTO.ticketsInfo().stream().iterator();
        var ticketPackage = ticketPackageService.findById(id);
        Set<String> personEmails = new HashSet<>();
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
            personEmails.add(person.getEmail());
        }

        return ResponseEntity.ok(tickets);
    }
}
