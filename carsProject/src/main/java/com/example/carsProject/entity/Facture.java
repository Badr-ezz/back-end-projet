package com.example.carsProject.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_paiment")
    private Paiment paiment;
}

