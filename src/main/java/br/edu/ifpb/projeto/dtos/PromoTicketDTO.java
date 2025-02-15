package br.edu.ifpb.projeto.dtos;

import java.util.UUID;

public record PromoTicketDTO(UUID event_id, UUID modality_id, UUID event_info_id) {
}
