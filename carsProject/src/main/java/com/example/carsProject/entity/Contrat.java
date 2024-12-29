package com.example.carsProject.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> regles = new ArrayList<>();

    // must add foreign key here
    @OneToOne(mappedBy = "contrat", cascade = CascadeType.ALL)
    private Reservation reservation;

    public boolean confirmation;
}

