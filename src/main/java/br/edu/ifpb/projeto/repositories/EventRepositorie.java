package br.edu.ifpb.projeto.repositories;

import br.edu.ifpb.projeto.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepositorie extends JpaRepository<Event, UUID> {}
