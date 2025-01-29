package br.edu.ifpb.projeto.controllers;


import br.edu.ifpb.projeto.models.Person;
import br.edu.ifpb.projeto.services.PersonServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        Person savedPerson = personServices.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personServices.findAll();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable UUID id) {
        Optional<Person> person = Optional.ofNullable(personServices.findById(id));
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()).getBody();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable UUID id, @RequestBody Person personDetails) {
        Optional<Person> personOptional = Optional.ofNullable(personServices.findById(id));

        if (personOptional.isPresent()) {
            Person person = personOptional.get();

            person.setName(personDetails.getName());
            person.setEmail(personDetails.getEmail());
            person.setPassword(personDetails.getPassword());
            person.setCpf(personDetails.getCpf());
            person.setBirthday(personDetails.getBirthday());

            Person updatedPerson = personServices.update(person);

            return ResponseEntity.ok(updatedPerson);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Person id) {
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }


}
