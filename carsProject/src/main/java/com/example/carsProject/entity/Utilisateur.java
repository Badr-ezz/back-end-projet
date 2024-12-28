package com.example.carsProject.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String firstName;

    private String lastName;

    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;


    @Enumerated(EnumType.STRING) // Enregistre la valeur (CLIENT/ADMIN) comme une chaîne dans la base de données
    private RoleType role;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Reservation> reservations;

}
