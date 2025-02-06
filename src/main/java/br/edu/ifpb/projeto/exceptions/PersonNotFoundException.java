package br.edu.ifpb.projeto.exceptions;

import java.util.UUID;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(UUID id) {
        super(String.format("Organizer with id %s not found", id));
    }
}
