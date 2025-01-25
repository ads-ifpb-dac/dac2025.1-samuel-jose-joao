package br.edu.ifpb.projeto.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Event event;

    @ManyToOne
    private User owner;

    @ManyToOne
    private EventInfo eventDate;

    @ManyToOne
    private Modality modality;

    @OneToMany
    private List<FieldResponse> responseList;
}
