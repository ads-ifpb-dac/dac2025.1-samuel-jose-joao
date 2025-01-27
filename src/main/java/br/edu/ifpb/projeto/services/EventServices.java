package br.edu.ifpb.projeto.services;

import br.edu.ifpb.projeto.models.Event;
import br.edu.ifpb.projeto.repositories.EventRepositorie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServices {
    private EventRepositorie eventRepositorie;

    public EventServices(EventRepositorie eventRepositorie) {
        this.eventRepositorie = eventRepositorie;
    }

    public List<Event> getAll() {
        return eventRepositorie.findAll();
    }

    public void create(Event event) {
        eventRepositorie.save(event);
    }

    public Optional<Event> findById(Long id) {
        return eventRepositorie.findById(id);
    }

    public void update(Event event) {
        eventRepositorie.save(event);
    }

    public void delete(Long id) {
        eventRepositorie.deleteById(id);
    }

}
