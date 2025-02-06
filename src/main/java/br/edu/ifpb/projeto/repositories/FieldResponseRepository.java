package br.edu.ifpb.projeto.repositories;

import br.edu.ifpb.projeto.models.FieldResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FieldResponseRepository extends JpaRepository<FieldResponse, UUID> {
}
