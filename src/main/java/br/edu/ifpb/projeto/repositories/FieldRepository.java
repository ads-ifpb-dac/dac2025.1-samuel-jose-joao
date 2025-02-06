package br.edu.ifpb.projeto.repositories;

import br.edu.ifpb.projeto.models.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FieldRepository extends JpaRepository<Field, UUID> { }
