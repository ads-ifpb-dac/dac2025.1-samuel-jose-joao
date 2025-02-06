package br.edu.ifpb.projeto.services;

import br.edu.ifpb.projeto.exceptions.OrganizerNotFoundException;
import br.edu.ifpb.projeto.models.Organizer;
import br.edu.ifpb.projeto.repositories.OrganizerRepository;
import br.edu.ifpb.projeto.utils.GenericCRUDService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizerServices implements GenericCRUDService<Organizer> {

    private final OrganizerRepository organizerRepository;

    public OrganizerServices(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }

    public Organizer save(Organizer organizer) {
        return this.organizerRepository.save(organizer);
    }

    public List<Organizer> findAll() {
        return this.organizerRepository.findAll();
    }

    public Organizer findById(UUID id) {
        return this.organizerRepository.findById(id).orElseThrow(() -> new OrganizerNotFoundException(id));
    }

    public Organizer update(Organizer organizer) {
        return this.organizerRepository.save(organizer);
    }

    public void delete(Organizer person) {
        this.organizerRepository.delete(person);
    }

    @Override
    public void delete(UUID id) {
        this.organizerRepository.deleteById(id);
    }


}
