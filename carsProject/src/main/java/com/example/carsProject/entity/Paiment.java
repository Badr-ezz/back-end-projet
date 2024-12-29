package com.example.carsProject.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Paiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int montant;

    private Date datePaiment;

    private String modePaiment;

    private String status;

    @OneToOne(mappedBy = "paiment", cascade = CascadeType.ALL)
    private Reservation reservation;

    @OneToOne(mappedBy = "paiment", cascade = CascadeType.ALL)
    private Facture facture;
}

