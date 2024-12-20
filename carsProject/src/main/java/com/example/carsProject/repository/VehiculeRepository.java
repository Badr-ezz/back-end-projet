package com.example.carsProject.repository;

import com.example.carsProject.entity.Vehicule;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

        @Query("SELECT DISTINCT v.marque FROM Vehicule v")
        List<String> findDistinctMarque();

        @Query("SELECT DISTINCT v.vehiculeType FROM Vehicule v")
        List<String> findDistinctVehiculeType();

        @Query("SELECT DISTINCT v.annee FROM Vehicule v")
        List<Integer> findDistinctAnnee();

        @Query("SELECT DISTINCT v.status FROM Vehicule v")
        List<String> findDistinctStatus();

        @Query("SELECT v FROM Vehicule v WHERE " +
                "(:marque IS NULL OR v.marque = :marque) AND " +
                "(:type IS NULL OR v.vehiculeType = :type) AND " +
                "(:annee IS NULL OR v.annee = :annee) AND " +
                "(:disponibilite IS NULL OR v.status = :disponibilite) AND " +
                "(:tarif IS NULL OR v.prix <= :tarif)")
        List<Vehicule> findFilteredVehicules(
                @Param("marque") String marque,
                @Param("type") String type,
                @Param("annee") Integer annee,
                @Param("disponibilite") String disponibilite,
                @Param("tarif") Float tarif);

}
