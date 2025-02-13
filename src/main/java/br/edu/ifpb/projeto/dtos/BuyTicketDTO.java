package br.edu.ifpb.projeto.dtos;

import java.util.List;
import java.util.UUID;

public record BuyTicketDTO(UUID owner_id, List<ResponseDTO> fields) {
}
