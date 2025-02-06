package br.edu.ifpb.projeto.controllers;

import br.edu.ifpb.projeto.dtos.EventDTO;
import br.edu.ifpb.projeto.models.Event;
import br.edu.ifpb.projeto.services.EventServices;
import org.springframework.beans.BeanUtils;
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
        var savedEvent = eventServices.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventServices.findAll();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable UUID id) {
        return eventServices.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable UUID id, @RequestBody EventDTO eventDTO) {
        var event = eventServices.findById(id);
        BeanUtils.copyProperties(eventDTO, event);
        eventServices.update(event);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable UUID id) {
        eventServices.delete(id);
    }

}
