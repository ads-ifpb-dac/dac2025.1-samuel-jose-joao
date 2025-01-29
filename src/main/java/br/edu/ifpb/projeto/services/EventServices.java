package br.edu.ifpb.projeto.services;

import br.edu.ifpb.projeto.models.Event;
import br.edu.ifpb.projeto.repositories.EventRepositorie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventServices {
    private EventRepositorie eventRepositorie;

    public EventServices(EventRepositorie eventRepositorie) {
        this.eventRepositorie = eventRepositorie;
    }

    public Event save(Event event) {
        eventRepositorie.save(event);
        return event;
    }

    public List<Event> findAll() {
        return eventRepositorie.findAll();
    }

    public Optional<Event> findById(UUID id) {
        return eventRepositorie.findById(id);
    }

    public void update(Event event) {
        eventRepositorie.save(event);
    }

    public void delete(UUID id) {
        eventRepositorie.deleteById(id);
    }

}
