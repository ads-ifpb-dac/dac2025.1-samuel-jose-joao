package br.edu.ifpb.projeto.dtos;

import java.util.UUID;

public record PromoTicketDTO(UUID eventId, UUID modalityId, UUID eventInfoID) {
}
