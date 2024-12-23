package com.example.carsProject.service;

import com.example.carsProject.entity.RoleType;
import com.example.carsProject.entity.Utilisateur;
import com.example.carsProject.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    // Compter le nombre total d'utilisateurs
        public Long countUtilisateurs() {
        return utilisateurRepository.count();
    }

    // Ajouter un utilisateur
    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        utilisateur.setPassword(encoder.encode(utilisateur.getPassword()));
        return utilisateurRepository.save(utilisateur);
    }

    // Mettre à jour un utilisateur existant
    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateurDetails) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + id));

        utilisateur.setFirstName(utilisateurDetails.getFirstName());
        utilisateur.setLastName(utilisateurDetails.getLastName());
        utilisateur.setEmail(utilisateurDetails.getEmail());
        utilisateur.setPhone(utilisateurDetails.getPhone());
        utilisateur.setRole(utilisateurDetails.getRole());

        return utilisateurRepository.save(utilisateur);
    }

    // Récupérer tous les utilisateurs
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // Récupérer les Utilisateurs par rôle (CLIENT ou ADMIN)
    public List<Utilisateur> getUtilisateursByRole(RoleType role) {
        return utilisateurRepository.findByRole(role);
    }

    // Récupérer un Utilisateur par ID
    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + id));
    }

    // Supprimer un utilisateur par ID
    public void deleteUtilisateur(Long id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new RuntimeException("Utilisateur non trouvé avec l'ID : " + id);
        }
        utilisateurRepository.deleteById(id);
    }

    public void deleteAllUtilisateurs() {
        utilisateurRepository.deleteAll();
    }

    // Filtrer les utilisateurs par prénom exact
    public List<Utilisateur> getUtilisateursByFirstName(String firstName) {
        return utilisateurRepository.findByFirstName(firstName);
    }

    // Filtrer les Utilisateurs par nom exact
    public List<Utilisateur> getUtilisateursByLastName(String lastName) {
        return utilisateurRepository.findByLastName(lastName);
    }

    // Filtrer les Utilisateurs contenant un mot-clé dans le prénom
    public List<Utilisateur> searchUtilisateursByFirstName(String keyword) {
        return utilisateurRepository.findByFirstNameContaining(keyword);
    }

    // Filtrer les utilisateurs contenant un mot-clé dans le nom
    public List<Utilisateur> searchUtilisateursByLastName(String keyword) {
        return utilisateurRepository.findByLastNameContaining(keyword);
    }

    // Filtrer les Utilisateurs par email exact
//    public List<Utilisateur> getUtilisateursByEmail(String email) {
//        return utilisateurRepository.findByEmail(email);
//    }

    // Filtrer les Utilisateurs par numéro de téléphone exact
    public List<Utilisateur> getUtilisateursByPhone(String phone) {
        return utilisateurRepository.findByPhone(phone);
    }

    public String verify(Utilisateur user) {
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        if(auth.isAuthenticated()) {
//            return jwtService.generateToken(user.getUsername());
            Utilisateur foundUser = utilisateurRepository.findByEmail(user.getEmail());
            System.out.println(foundUser);
            return jwtService.generateToken(foundUser);
        }
        return "fail";
    }

    public String logout (String token) {
        return jwtService.logout(token);
    }
}
