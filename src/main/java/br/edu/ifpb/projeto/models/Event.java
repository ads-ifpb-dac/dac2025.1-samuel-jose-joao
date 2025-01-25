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
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String description;

    @OneToMany
    private List<EventInfo> date;

    private Integer capacity;

    @ManyToMany
    private List<Organizer> organizers;

}
