package br.edu.ifpb.projeto.repositories;

import br.edu.ifpb.projeto.models.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrganizerRepositorie extends JpaRepository<Organizer, UUID> {
}
