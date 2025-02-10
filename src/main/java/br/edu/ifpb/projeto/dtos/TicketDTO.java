package br.edu.ifpb.projeto.dtos;

import br.edu.ifpb.projeto.models.*;

import java.util.List;
import java.util.UUID;

public record TicketDTO(UUID eventId, UUID eventInfoID, UUID modalityId, UUID owneriD, List<FieldResponseDTO> fields) { }
