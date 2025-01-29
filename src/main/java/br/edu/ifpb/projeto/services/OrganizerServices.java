package br.edu.ifpb.projeto.services;

import br.edu.ifpb.projeto.models.Organizer;
import br.edu.ifpb.projeto.models.Person;
import br.edu.ifpb.projeto.repositories.OrganizerRepositorie;
import br.edu.ifpb.projeto.repositories.PersonRepositorie;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizerServices {

    private OrganizerRepositorie organizerRepositorie;

    public OrganizerServices(OrganizerRepositorie organizerRepositorie) {
        this.organizerRepositorie = organizerRepositorie;
    }

    public Organizer save(Organizer organizer) {
        return this.organizerRepositorie.save(organizer);
    }

    public List<Organizer> findAll() {
        return this.organizerRepositorie.findAll();
    }

    public Organizer findById(UUID id) {
        return this.organizerRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public Organizer update(Organizer organizer) {
        return this.organizerRepositorie.save(organizer);
    }

    public void delete(Organizer person) {
        this.organizerRepositorie.delete(person);
    }




}
