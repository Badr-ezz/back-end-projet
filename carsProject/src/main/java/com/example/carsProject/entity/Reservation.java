package com.example.carsProject.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public Date dateDebut;

    public Date dateFin;

    public String status;


//    @ManyToOne
//    @JoinColumn(name = "id_utilisateur", nullable = false)
//    public Utilisateur utilisateur;
//
//    @ManyToOne
//    @JoinColumn(name = "id_vehicule", nullable = false)
//    public Vehicule vehicule;

}
