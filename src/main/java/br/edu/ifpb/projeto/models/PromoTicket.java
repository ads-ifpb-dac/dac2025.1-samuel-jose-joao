package br.edu.ifpb.projeto.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PromoTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Modality modality;

    @ManyToOne
    private Event event;

    @ManyToOne
    private EventInfo eventDate;


}
