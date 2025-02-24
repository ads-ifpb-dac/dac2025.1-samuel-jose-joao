package br.edu.ifpb.projeto.services;

import br.edu.ifpb.projeto.dtos.PromoTicketDTO;
import br.edu.ifpb.projeto.dtos.TicketPackageDTO;
import br.edu.ifpb.projeto.exceptions.TicketPackageNotFoundException;
import br.edu.ifpb.projeto.models.PromoTicket;
import br.edu.ifpb.projeto.models.TicketPackage;
import br.edu.ifpb.projeto.repositories.TicketPackageRepository;
import br.edu.ifpb.projeto.utils.GenericCRUDService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Service
public class TicketPackageService implements GenericCRUDService<TicketPackage> {

    private final TicketPackageRepository repository;

    private final EventService eventService;
    private final ModalityService modalityService;
    private final EventInfoService eventInfoService;

    public TicketPackageService(TicketPackageRepository repository, EventService eventService, ModalityService modalityService, EventInfoService eventInfoService) {
        this.repository = repository;
        this.eventService = eventService;
        this.modalityService = modalityService;
        this.eventInfoService = eventInfoService;
    }

    @Override
    public TicketPackage findById(UUID id) {
        return this.repository.findById(id).orElseThrow(() -> new TicketPackageNotFoundException(id));
    }

    @Override
    public List<TicketPackage> findAll() {
        return this.repository.findAll();
    }

    @Override
    public TicketPackage save(TicketPackage entity) {
        return this.repository.save(entity);
    }

    public TicketPackage save(TicketPackageDTO ticketPackageDTO) {
        if (ticketPackageDTO.ticketList().isEmpty()) {
            // Exceção
        }

        var ticketPackage = new TicketPackage();
        ticketPackage.setType(ticketPackageDTO.type());
        List<PromoTicket> ticketPackageList = ticketPackageDTO.ticketList().stream().map(convertPromoTicketDTO()).toList();
        ticketPackage.setTicketOptions(ticketPackageList);
        TicketPackage saved = save(ticketPackage);



    }

    public Function<PromoTicketDTO, PromoTicket> convertPromoTicketDTO() {
        return ticket -> {
            var promoTicket = new PromoTicket();
            var event = eventService.findById(ticket.eventId());
            var eventInfo = eventInfoService.findById(ticket.eventInfoID());
            var modality = modalityService.findById(ticket.modalityId());
            promoTicket.setEvent(event);
            promoTicket.setModality(modality);
            promoTicket.setEventDate(eventInfo);
            return promoTicket;
        };
    }

    @Override
    public void delete(TicketPackage entity) {
        this.repository.delete(entity);
    }

    @Override
    public void delete(UUID id) {
        this.repository.deleteById(id);
    }
}
