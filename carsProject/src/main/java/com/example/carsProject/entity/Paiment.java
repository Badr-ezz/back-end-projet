package com.example.carsProject.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Paiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public int montant;

    public Date datePaiment;

    public String modePaiment;

    public String status;

    @OneToOne(mappedBy = "paiment", cascade = CascadeType.ALL)
    private Reservation reservation;

    @OneToOne(mappedBy = "paiment", cascade = CascadeType.ALL)
    private Facture facture;
}

