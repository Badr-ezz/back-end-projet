package com.example.carsProject.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateDebut;

    private Date dateFin;

    private String status;


    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_vehicule", nullable = false)
    private Vehicule vehicule;

    @OneToOne
    @JoinColumn(name = "id_contrat")
    private Contrat contrat;

    @OneToOne
    @JoinColumn(name = "id_paiment")
    private Paiment paiment;
}
