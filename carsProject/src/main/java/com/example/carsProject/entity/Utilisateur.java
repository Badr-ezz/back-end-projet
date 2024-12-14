package com.example.carsProject.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String FirstName;

    private String LastName;

    private String email;

    private String phone;


    @Enumerated(EnumType.STRING) // Enregistre la valeur (CLIENT/ADMIN) comme une chaîne dans la base de données
    private RoleType role;

}
