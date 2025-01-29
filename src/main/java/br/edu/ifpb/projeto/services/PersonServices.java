package br.edu.ifpb.projeto.services;

import br.edu.ifpb.projeto.models.Person;
import br.edu.ifpb.projeto.repositories.PersonRepositorie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonServices {

    private PersonRepositorie personRepositorie;

    public PersonServices(PersonRepositorie personRepositorie) {
        this.personRepositorie = personRepositorie;
    }

    public Person save(Person person) {
        this.personRepositorie.save(person);
        return person;
    }

    public List<Person> findAll() {
        return this.personRepositorie.findAll();
    }

    public Person findById(UUID id) {
        return this.personRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public Person update(Person person) {
        this.personRepositorie.save(person);
        return person;
    }

    public void delete(Person person) {
        this.personRepositorie.delete(person);
    }
}
