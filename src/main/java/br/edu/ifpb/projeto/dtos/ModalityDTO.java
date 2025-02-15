package br.edu.ifpb.projeto.dtos;

import br.edu.ifpb.projeto.models.Field;

import java.util.List;

public record ModalityDTO(String type, List<Field> fields) {
}
