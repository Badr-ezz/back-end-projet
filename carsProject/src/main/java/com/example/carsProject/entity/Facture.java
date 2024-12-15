package com.example.carsProject.entity;


import jakarta.persistence.*;

@Entity
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne
    @JoinColumn(name = "id_paiment")
    private Paiment paiment;
}

