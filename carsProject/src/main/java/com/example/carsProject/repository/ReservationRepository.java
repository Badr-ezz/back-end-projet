package com.example.carsProject.repository;

import com.example.carsProject.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.utilisateur.id = :userId AND r.status = 'entretient' ")
    List<Reservation> findByUtilisateurId(@Param("userId") Long userId);

    @Query("SELECT r FROM Reservation r WHERE r.vehicule.id = :vehicleId AND r.status = 'reserve' AND (:newStartDate <= r.dateFin AND :newEndDate >= r.dateDebut)")
    List<Reservation> findConflictingReservations(@Param("vehicleId") Long vehicleId,
                                                  @Param("newStartDate") LocalDate newStartDate,
                                                  @Param("newEndDate") LocalDate newEndDate);


}



