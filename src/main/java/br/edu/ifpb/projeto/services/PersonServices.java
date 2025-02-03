package br.edu.ifpb.projeto.services;

import br.edu.ifpb.projeto.models.Person;
import br.edu.ifpb.projeto.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonServices {

    private PersonRepository personRepository;

    public PersonServices(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        this.personRepository.save(person);
        return person;
    }

    public List<Person> findAll() {
        return this.personRepository.findAll();
    }

    public Person findById(UUID id) {
        return this.personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public Person update(Person person) {
        this.personRepository.save(person);
        return person;
    }

    public void delete(Person person) {
        this.personRepository.delete(person);
    }
}
