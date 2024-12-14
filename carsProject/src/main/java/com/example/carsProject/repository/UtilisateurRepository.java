package com.example.carsProject.repository;

import com.example.carsProject.entity.RoleType;
import com.example.carsProject.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Récupérer les utilisateurs par rôle
     List<Utilisateur> findByRole(RoleType role);

    // Rechercher les Utilisateurs par prénom exact
    List<Utilisateur> findByFirstName(String firstName);

    // Rechercher les Utilisateurs par nom exact
    List<Utilisateur> findByLastName(String lastName);

    // Rechercher les Utilisateurs contenant un mot-clé dans le prénom
    List<Utilisateur> findByFirstNameContaining(String keyword);

    // Rechercher les Utilisateurs contenant un mot-clé dans le nom
    List<Utilisateur> findByLastNameContaining(String keyword);

    // Rechercher les Utilisateurs par email exact
    List<Utilisateur> findByEmail(String email);

    // Rechercher les Utilisateurs par numéro de téléphone exact
    List<Utilisateur> findByPhone(String phone);

}
