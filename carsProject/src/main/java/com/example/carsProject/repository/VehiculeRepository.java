package com.example.carsProject.repository;

import com.example.carsProject.entity.Vehicule;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
        public List<Vehicule> findByMarque(String marque);

        public List<Vehicule> findByModele(String modele);

        public List<Vehicule> findByPrixLessThan(Float prix);

        public List<Vehicule> findByVehiculeType(String vehiculeType);

        public List<Vehicule> findByAnnee(Integer annee);

        public List<Vehicule> findByStatus(String status);


}
