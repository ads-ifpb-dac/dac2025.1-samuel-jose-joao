package br.edu.ifpb.projeto.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Field implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String type;

    private String description;

    @ManyToOne
    private Modality modality;

    @OneToOne
    private FieldResponse response;

}
