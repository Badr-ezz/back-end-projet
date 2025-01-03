package com.example.carsProject.controller;

import com.example.carsProject.entity.RoleType;
import com.example.carsProject.entity.Utilisateur;
import com.example.carsProject.service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateur")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    // Ajouter un utilisateur
    @PostMapping
    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur newUtilisateur = utilisateurService.addUtilisateur(utilisateur);
        return ResponseEntity.ok(newUtilisateur);
    }

    // Mettre à jour un utilisateur existant
    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateurDetails) {
        Utilisateur updatedUtilisateur = utilisateurService.updateUtilisateur(id, utilisateurDetails);
        return ResponseEntity.ok(updatedUtilisateur);
    }

    // Récupérer tous les utilisateurs
    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        return ResponseEntity.ok(utilisateurService.getAllUtilisateurs());
    }

    // Récupérer un utilisateur par ID
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        return ResponseEntity.ok(utilisateur);
    }

    // Récupérer les utilisateurs par rôle (CLIENT ou ADMIN)
    @GetMapping("/role")
    public ResponseEntity<List<Utilisateur>> getUtilisateursByRole(@RequestParam RoleType role) {
        return ResponseEntity.ok(utilisateurService.getUtilisateursByRole(role));
    }

    // Supprimer un utilisateur par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
        return ResponseEntity.noContent().build();
    }

    // Supprimer tous les utilisateurs
    @DeleteMapping
    public ResponseEntity<Void> deleteAllUtilisateurs() {
        utilisateurService.deleteAllUtilisateurs();
        return ResponseEntity.noContent().build();
    }

    // Compter le nombre total d'utilisateurs
    @GetMapping("/count")
    public ResponseEntity<Long> countUtilisateurs() {
        return ResponseEntity.ok(utilisateurService.countUtilisateurs());
    }

    // Filtrer les utilisateurs par prénom exact
    @GetMapping("/byFirstName")
    public ResponseEntity<List<Utilisateur>> getUtilisateursByFirstName(@RequestParam String firstName) {
        return ResponseEntity.ok(utilisateurService.getUtilisateursByFirstName(firstName));
    }

    // Filtrer les utilisateurs par nom exact
    @GetMapping("/byLastName")
    public ResponseEntity<List<Utilisateur>> getUtilisateursByLastName(@RequestParam String lastName) {
        return ResponseEntity.ok(utilisateurService.getUtilisateursByLastName(lastName));
    }

    // Rechercher les Utilisateurs contenant un mot-clé dans le prénom
    @GetMapping("/searchByFirstName")
    public ResponseEntity<List<Utilisateur>> searchUtilisateursByFirstName(@RequestParam String keyword) {
        return ResponseEntity.ok(utilisateurService.searchUtilisateursByFirstName(keyword));
    }

    // Rechercher les utilisateurs contenant un mot-clé dans le nom
    @GetMapping("/searchByLastName")
    public ResponseEntity<List<Utilisateur>> searchUtilisateursByLastName(@RequestParam String keyword) {
        return ResponseEntity.ok(utilisateurService.searchUtilisateursByLastName(keyword));
    }

    // Filtrer les utilisateurs par email exact
    @GetMapping("/byEmail")
    public ResponseEntity<List<Utilisateur>> getUtilisateursByEmail(@RequestParam String email) {
        return ResponseEntity.ok(utilisateurService.getUtilisateursByEmail(email));
    }

    // Filtrer les utilisateurs par numéro de téléphone exact
    @GetMapping("/byPhone")
    public ResponseEntity<List<Utilisateur>> getUtilisateursByPhone(@RequestParam String phone) {
        return ResponseEntity.ok(utilisateurService.getUtilisateursByPhone(phone));
    }
}
