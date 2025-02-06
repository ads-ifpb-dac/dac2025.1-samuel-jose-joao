package br.edu.ifpb.projeto.controllers;

import br.edu.ifpb.projeto.models.Organizer;
import br.edu.ifpb.projeto.services.OrganizerServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {

    private OrganizerServices organizerServices;

    public OrganizerController(OrganizerServices organizerServices) {
        this.organizerServices = organizerServices;
    }

    @PostMapping
    public ResponseEntity<Organizer> saveOrganizers(@RequestBody Organizer organizer) {
        Organizer savedOrganizer = organizerServices.save(organizer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrganizer);
    }

    @GetMapping
    public List<Organizer> getAllOrganizers() {
        return organizerServices.findAll();
    }

    @GetMapping("/{id}")
    public Organizer getOrganizerById(@PathVariable UUID id) {
        return organizerServices.findById(id);
    }

    // PRECISA IMPLEMENTAR O PUT

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Organizer id) {
        organizerServices.delete(id);
        return ResponseEntity.noContent().build();
    }

}
