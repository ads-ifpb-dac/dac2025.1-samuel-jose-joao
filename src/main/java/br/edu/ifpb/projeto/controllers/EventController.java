package br.edu.ifpb.projeto.controllers;

import br.edu.ifpb.projeto.models.Event;
import br.edu.ifpb.projeto.services.EventServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventServices eventServices;

    public EventController(EventServices eventServices) {
        this.eventServices = eventServices;
    }

    @PostMapping
    public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
        Event savedEvent = eventServices.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventServices.findAll();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable UUID id) {
        return eventServices.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable UUID id, @RequestBody Event event) {
        Event existingEvent = eventServices.findById(id).orElse(null);
        if(existingEvent != null) {
            eventServices.update(event);
            return event;
        } else {
            throw new RuntimeException("Event not found");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable UUID id) {
        eventServices.delete(id);
    }

}
