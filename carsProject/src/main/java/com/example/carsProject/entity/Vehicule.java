package com.example.carsProject.entity;


import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String marque;

    public float prix;

    public String vehiculeType;

    public Integer quantite;

    public Integer annee;

    public String modele;

    public String status;

    public Integer nbrReservateurs;

}
