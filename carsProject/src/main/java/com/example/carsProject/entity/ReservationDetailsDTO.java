package com.example.carsProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ReservationDetailsDTO {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String marque;
    private String modele;
    private float carPrice;

    private float montant;
    private LocalDate datePaiment;

    public ReservationDetailsDTO(Long id, LocalDate dateDebut, LocalDate dateFin, String marque, String modele, float montant,float carPrice, LocalDate datePaiment) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.marque = marque;
        this.modele = modele;
        this.carPrice = carPrice;
        this.datePaiment = datePaiment;
        this.montant=montant;
    }

    // Getters and setters (optional but recommended)
}