package com.example.carsProject.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Data
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public Long id;

    public String marque;

    public float prix;

    public String description;

    public String vehiculeType;

    public Integer quantite;

    public Integer annee;

    public String modele;

    public String status;

    public Integer nbrReservateurs;

    public String imagepath;

    public String detailpic;

    public String logoPath;

    public String features;

    public Integer maxCount;

    public String vitesse;

    public String Fuel;

    @OneToMany(mappedBy = "vehicule",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reservation> reservations;
}
