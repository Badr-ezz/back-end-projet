package com.example.carsProject.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Paiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int montant;

    private LocalDate datePaiment;

    private String modePaiment;

    private String status;

    private String cinClient;

    private String numeroCarteBancaire;

    @OneToOne(mappedBy = "paiment", cascade = CascadeType.ALL)
    @JsonIgnore
    private Reservation reservation;

    @OneToOne(mappedBy = "paiment", cascade = CascadeType.ALL)
    private Facture facture;
}