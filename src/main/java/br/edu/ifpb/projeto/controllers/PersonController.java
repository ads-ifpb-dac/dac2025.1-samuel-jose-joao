package br.edu.ifpb.projeto.controllers;


import br.edu.ifpb.projeto.dtos.PersonDTO;
import br.edu.ifpb.projeto.models.Person;
import br.edu.ifpb.projeto.services.PersonServices;
import br.edu.ifpb.projeto.utils.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonServices personServices;

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
        return personServices.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable UUID id, @RequestBody PersonDTO personDetails) {
        var person = personServices.findById(id);
        BeanUtils.copyProperties(personDetails, person, ObjectUtils.getNullPropertyNames(personDetails));
        personServices.save(person);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Person id) {
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }


}
