package com.example.carsProject.repository;

import com.example.carsProject.entity.Reservation;
import com.example.carsProject.entity.ReservationDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.utilisateur.id = :userId AND r.status='entretient' ")
    List<Reservation> findByUtilisateurId(@Param("userId") Long userId);

    @Query("SELECT r FROM Reservation r WHERE r.vehicule.id = :vehicleId AND r.status = 'reserve' AND (:newStartDate <= r.dateFin AND :newEndDate >= r.dateDebut)")
    List<Reservation> findConflictingReservations(@Param("vehicleId") Long vehicleId,
                                                  @Param("newStartDate") LocalDate newStartDate,
                                                  @Param("newEndDate") LocalDate newEndDate);
    @Query("SELECT r FROM Reservation r WHERE r.utilisateur.id = :userId  ")
    List<Reservation> findByUtilisateurIdAll(@Param("userId") Long userId);

    @Query("SELECT new com.example.carsProject.entity.ReservationDetailsDTO(r.id, r.dateDebut, r.dateFin, v.marque, v.modele, p.montant,v.prix, p.datePaiment) " +
            "FROM Reservation r " +
            "JOIN r.vehicule v " +
            "JOIN r.paiment p " +
            "WHERE r.id = :reservationId")
    Optional<ReservationDetailsDTO> findReservationDetailsById(@Param("reservationId") Long reservationId);
}
