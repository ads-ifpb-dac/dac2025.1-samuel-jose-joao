package br.edu.ifpb.projeto.services;

import br.edu.ifpb.projeto.dtos.ResponseDTO;
import br.edu.ifpb.projeto.exceptions.TicketNotFoundException;
import br.edu.ifpb.projeto.models.Field;
import br.edu.ifpb.projeto.models.FieldResponse;
import br.edu.ifpb.projeto.models.Modality;
import br.edu.ifpb.projeto.models.Ticket;
import br.edu.ifpb.projeto.repositories.TicketRepository;
import br.edu.ifpb.projeto.utils.GenericCRUDService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService implements GenericCRUDService<Ticket> {

    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket findTicket(UUID event, UUID eventDate, UUID modality){
        var tickets = this.repository.findByEvent_IdAndEventDate_IdAndModality_IdAndOwnerIsNull(event, eventDate, modality);
        if(tickets.isEmpty()){
            throw new RuntimeException("Ticket not found for package");
        }
        return tickets.get(0);
    }

    public static List<FieldResponse> fillTicket(List<ResponseDTO> responseDTOList, Modality modality){
        var responses = new ArrayList<FieldResponse>();
        for (var field : responseDTOList) {
            for (var modalField : modality.getFields()) {
                if (field.fieldID().equals(modalField.getId())) {
                    var response = new FieldResponse();
                    response.setField(modalField);
                    response.setContent(field.response());
                    responses.add(response);
                }
            }
        }
        return responses;
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
