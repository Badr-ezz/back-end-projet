package com.example.carsProject.repository;

import com.example.carsProject.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.utilisateur.id = :userId")
    List<Reservation> findByUtilisateurId(@Param("userId") Long userId);


}
