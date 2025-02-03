package br.edu.ifpb.projeto.services;

import br.edu.ifpb.projeto.models.Event;
import br.edu.ifpb.projeto.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventServices {
    private EventRepository eventRepository;

    public EventServices(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event save(Event event) {
        eventRepository.save(event);
        return event;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Optional<Event> findById(UUID id) {
        return eventRepository.findById(id);
    }

    public void update(Event event) {
        eventRepository.save(event);
    }

    public void delete(UUID id) {
        eventRepository.deleteById(id);
    }

}
