package br.edu.ifpb.projeto.repositories;

import br.edu.ifpb.projeto.models.Ticket;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {

    @Query("SELECT T FROM Ticket T where T.event.id = ?1 AND  t.eventDate.id = ?2 AND T.modality.id = ?3")
    List<Ticket> findTicket(UUID event , UUID eventDate, UUID modality);
}
