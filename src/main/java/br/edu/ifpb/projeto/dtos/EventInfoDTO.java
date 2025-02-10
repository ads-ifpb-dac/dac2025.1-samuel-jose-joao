package br.edu.ifpb.projeto.dtos;

import java.time.LocalDateTime;

public record EventInfoDTO(LocalDateTime eventStart, LocalDateTime eventEnd, String address) {
}
