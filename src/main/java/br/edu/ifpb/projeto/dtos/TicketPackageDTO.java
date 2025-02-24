package br.edu.ifpb.projeto.dtos;

import java.util.List;

public record TicketPackageDTO(String type, List<PromoTicketDTO> ticketList) { }
