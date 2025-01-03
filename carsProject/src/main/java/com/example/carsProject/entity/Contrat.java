package com.example.carsProject.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ElementCollection
    public List<String> regles = new ArrayList<>();

    // must add foreign key here
    @OneToOne(mappedBy = "contrat", cascade = CascadeType.ALL)
    private Reservation reservation;

    public boolean confirmation;
}

