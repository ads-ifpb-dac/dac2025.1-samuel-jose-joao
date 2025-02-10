package br.edu.ifpb.projeto.repositories;

import br.edu.ifpb.projeto.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}
