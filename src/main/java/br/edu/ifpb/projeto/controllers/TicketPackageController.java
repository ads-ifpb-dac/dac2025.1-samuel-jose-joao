package br.edu.ifpb.projeto.controllers;


import br.edu.ifpb.projeto.dtos.BuyPackageDTO;
import br.edu.ifpb.projeto.dtos.BuyTicketDTO;
import br.edu.ifpb.projeto.dtos.PromoTicketDTO;
import br.edu.ifpb.projeto.dtos.TicketPackageDTO;
import br.edu.ifpb.projeto.models.PromoTicket;
import br.edu.ifpb.projeto.models.Ticket;
import br.edu.ifpb.projeto.models.TicketPackage;
import br.edu.ifpb.projeto.services.*;
import org.springframework.web.bind.annotation.*;

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

    public TicketPackageController(TicketPackageService ticketPackageService, EventService eventService, ModalityService modalityService, EventInfoService eventInfoService, TicketService ticketService) {
        this.ticketPackageService = ticketPackageService;
        this.eventService = eventService;
        this.modalityService = modalityService;
        this.eventInfoService = eventInfoService;
        this.ticketService = ticketService;
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

    /*@PostMapping("/buy/{id}")
    public TicketPackage buy(@PathVariable UUID id, @RequestBody BuyPackageDTO buyPackageDTO) {
        var ticketPackage = ticketPackageService.findById(id);
        for (BuyTicketDTO ticketDTO: buyPackageDTO.ticketsInfo()){

        }
    }*/
}
