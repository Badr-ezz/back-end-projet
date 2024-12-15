package com.example.carsProject.service;


import com.example.carsProject.entity.Vehicule;
import com.example.carsProject.repository.VehiculeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeService {
    public final VehiculeRepository vehiculeRepository;

    public Long coutVehicule() { return vehiculeRepository.count(); }

    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    public Vehicule updateVehicule(Long id, Vehicule vehiculeDetails) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicule non trouvé avec l'ID : " + id));
        ;

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
        return vehiculeRepository.findByMarque( marque);
    }

    public List<Vehicule> getVehiculeByModele(String modele) {
        return vehiculeRepository.findByModele(modele);
    }

    public List<Vehicule> getVehiculeByPrixLessThan(float prix){
        return vehiculeRepository.findByPrixLessThan(prix);
    };

    public List<Vehicule> getVehiculeByType(String vehiculeType){
        return vehiculeRepository.findByVehiculeType(vehiculeType);
    };

    public List<Vehicule> getVehiculeByAnnee(Integer annee){
        return vehiculeRepository.findByAnnee(annee);
    };

    public List<Vehicule> getVehiculeByStatus(String status){
        return vehiculeRepository.findByStatus(status);
    };



}
