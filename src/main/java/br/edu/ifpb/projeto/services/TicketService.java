package br.edu.ifpb.projeto.services;

import br.edu.ifpb.projeto.exceptions.TicketNotFoundException;
import br.edu.ifpb.projeto.models.Ticket;
import br.edu.ifpb.projeto.repositories.TicketRepository;
import br.edu.ifpb.projeto.utils.GenericCRUDService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketService implements GenericCRUDService<Ticket> {

    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public List<Ticket> findTicket(UUID event, UUID eventDate, UUID modality){
        return this.repository.findTicket(event, eventDate, modality);
    }


    @Override
    public Ticket findById(UUID id) {
        return this.repository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
    }

    @Override
    public List<Ticket> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Ticket save(Ticket entity) {
        return this.repository.save(entity);
    }

    @Override
    public void delete(Ticket entity) {
        this.repository.delete(entity);
    }

    @Override
    public void delete(UUID id) {
        this.repository.deleteById(id);
    }
}
