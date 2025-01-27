package br.edu.ifpb.projeto.controllers;

import br.edu.ifpb.projeto.models.Event;
import br.edu.ifpb.projeto.services.EventServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventServices eventServices;

    public EventController(EventServices eventServices) {
        this.eventServices = eventServices;
    }

    @GetMapping
    public List<Event> getAll() {
        return eventServices.getAll();
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        eventServices.create(event);
        return event;
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Long id) {
        return eventServices.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        Event existingEvent = eventServices.findById(id).orElse(null);
        if(existingEvent != null) {
            eventServices.update(event);
            return event;
        } else {
            throw new RuntimeException("Event not found");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventServices.delete(id);
    }


}
