package com.example.carsProject.service;


import com.example.carsProject.entity.Reservation;
import com.example.carsProject.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
     private final ReservationRepository reservationRepository;
     private final UtilisateurService utilisateurService;
     private final VehiculeService vehiculeService;

     public Reservation addReservation(Reservation reservation) {
//         Long userid = reservation.getUtilisateur().getId();
//         Long vehiculeid = reservation.getVehicule().getId();
//         reservation.setUtilisateur(utilisateurService.getUtilisateurById(userid));
//         reservation.setVehicule(vehiculeService.getVehiculeById(vehiculeid));
         return reservationRepository.save(reservation);
     }

    public  List<Reservation> getAllReservation() {
         List<Reservation> reservations = reservationRepository.findAll();
         return reservations;
    }
}
