package com.example.carsProject.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ElementCollection;
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

    public boolean confirmation;
}

