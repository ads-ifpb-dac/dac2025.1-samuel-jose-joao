package br.edu.ifpb.projeto.repositories;

import br.edu.ifpb.projeto.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepositorie extends JpaRepository<Person, UUID> {
}
