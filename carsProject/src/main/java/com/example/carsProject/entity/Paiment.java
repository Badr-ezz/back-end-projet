package com.example.carsProject.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

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


//    @ManyToOne
//    @JoinColumn(name = "id_reservation", nullable = false)
//    public Reservation reservation;

}

