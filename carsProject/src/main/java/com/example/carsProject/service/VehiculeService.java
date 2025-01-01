package com.example.carsProject.service;

import com.example.carsProject.entity.Reservation;
import com.example.carsProject.entity.Vehicule;
import com.example.carsProject.repository.ReservationRepository;
import com.example.carsProject.repository.VehiculeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehiculeService {
    public final VehiculeRepository vehiculeRepository;
    public final ReservationRepository reservationRepository;

    public Long countVehicule() { return vehiculeRepository.count(); }

    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    public Vehicule updateVehicule(Long id, Vehicule vehiculeDetails) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicule non trouvé avec l'ID : " + id));

        vehicule.setAnnee(vehiculeDetails.getAnnee());
        vehicule.setMarque(vehiculeDetails.getMarque());
        vehicule.setModele(vehiculeDetails.getModele());
        vehicule.setPrix(vehiculeDetails.getPrix());
        vehicule.setQuantite(vehiculeDetails.getQuantite());
        vehicule.setStatus(vehiculeDetails.getStatus());
        vehicule.setVehiculeType(vehiculeDetails.getVehiculeType());
        vehicule.setNbrReservateurs(vehiculeDetails.getNbrReservateurs());
        return vehiculeRepository.save(vehicule);
    }

    public List<Vehicule> getAllUVehicule() {
        return vehiculeRepository.findAll();
    }

    public Vehicule getVehiculeById(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicule non trouvé avec l'ID : " + id));
    }

    public void deleteVehicule(Long id) {
        if (!vehiculeRepository.existsById(id)) {
            throw new RuntimeException("Vehicule non trouvé avec l'ID : " + id);
        }
        vehiculeRepository.deleteById(id);
    }

    public void deleteAllVehicules() {
        vehiculeRepository.deleteAll();
    }

    public List<Vehicule> getVehiculeByMarque(String marque) {
        return vehiculeRepository.findByMarque(marque);
    }

    public List<Vehicule> getVehiculeByModele(String modele) {
        return vehiculeRepository.findByModele(modele);
    }

    public List<Vehicule> getVehiculeByPrixLessThan(float prix){
        return vehiculeRepository.findByPrixLessThan(prix);
    }

    public List<Vehicule> getVehiculeByType(String vehiculeType){
        return vehiculeRepository.findByVehiculeType(vehiculeType);
    }

    public List<Vehicule> getVehiculeByAnnee(Integer annee){
        return vehiculeRepository.findByAnnee(annee);
    }

    public List<Vehicule> getVehiculeByStatus(String status){
        return vehiculeRepository.findByStatus(status);
    }

    public List<String> getAllUniqueMarques() {
        return vehiculeRepository.findDistinctMarque();
    }

    public List<String> getAllUniqueTypes() {
        return vehiculeRepository.findDistinctVehiculeType();
    }

    public List<Integer> getAllUniqueAnnees() {
        List<Integer> annees = vehiculeRepository.findDistinctAnnee();
        return annees != null ? annees : new ArrayList<>();
    }

    public List<String> getAllUniqueStatus() {
        return vehiculeRepository.findDistinctStatus();
    }

    public List<Vehicule> getFilteredVehicules(String marque, String type, Integer annee, String disponibilite, Float tarif, LocalDate startDate, LocalDate endDate, String searchTerm) {
        List<Vehicule> vehicules = vehiculeRepository.findAll();

        // Apply existing filters
        if (marque != null) {
            vehicules = vehicules.stream().filter(v -> v.getMarque().equalsIgnoreCase(marque)).collect(Collectors.toList());
        }
        if (type != null) {
            vehicules = vehicules.stream().filter(v -> v.getVehiculeType().equalsIgnoreCase(type)).collect(Collectors.toList());
        }
        if (annee != null) {
            vehicules = vehicules.stream().filter(v -> v.getAnnee().equals(annee)).collect(Collectors.toList());
        }
        if (disponibilite != null) {
            vehicules = vehicules.stream().filter(v -> v.getStatus().equalsIgnoreCase(disponibilite)).collect(Collectors.toList());
        }
        if (tarif != null) {
            vehicules = vehicules.stream().filter(v -> v.getPrix() <= tarif).collect(Collectors.toList());
        }

        // Apply date filtering
        if (startDate != null || endDate != null) {
            vehicules = vehicules.stream()
                    .filter(vehicule -> isVehiculeAvailable(vehicule.getId(), startDate, endDate))
                    .collect(Collectors.toList());
        }

        // Apply search term filtering
        if (searchTerm != null && !searchTerm.isEmpty()) {
            String lowerSearchTerm = searchTerm.toLowerCase();
            vehicules = vehicules.stream()
                    .filter(v -> v.getMarque().toLowerCase().contains(lowerSearchTerm) ||
                            v.getModele().toLowerCase().contains(lowerSearchTerm))
                    .collect(Collectors.toList());
        }

        return vehicules;
    }

    private boolean isVehiculeAvailable(Long vehiculeId, LocalDate startDate, LocalDate endDate) {
        if (startDate == null) {
            return true;
        }

        List<Reservation> conflictingReservations = reservationRepository.findConflictingReservations(
                vehiculeId,
                startDate,
                endDate != null ? endDate : startDate.plusYears(100)
        );

        return conflictingReservations.isEmpty();
    }
}

