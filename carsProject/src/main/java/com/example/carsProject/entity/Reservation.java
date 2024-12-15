package com.example.carsProject.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public Date dateDebut;

    public Date dateFin;

    public String status;


    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    public Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_vehicule", nullable = false)
    public Vehicule vehicule;

    @OneToOne
    @JoinColumn(name = "id_contrat")
    private Contrat contrat;

    @OneToOne
    @JoinColumn(name = "id_paiment")
    private Paiment paiment;
}
