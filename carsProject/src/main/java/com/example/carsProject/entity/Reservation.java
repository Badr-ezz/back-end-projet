package com.example.carsProject.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_vehicule", nullable = false)
    @JsonIgnore
    private Vehicule vehicule;

    @OneToOne
    @JoinColumn(name = "id_contrat")
    @JsonIgnore
    private Contrat contrat;

    @OneToOne
    @JoinColumn(name = "id_paiment")
    @JsonIgnore
    private Paiment paiment;

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", status='" + status + '\'' +
                '}';
    }

}
