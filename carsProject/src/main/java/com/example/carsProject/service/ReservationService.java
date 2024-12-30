package com.example.carsProject.service;


import com.example.carsProject.entity.Reservation;
import com.example.carsProject.entity.Vehicule;
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

    // Compter le nombre total de reservation
    public Long countReservations() {
        return reservationRepository.count();
    }

    public  List<Reservation> getAllReservation() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

    public List<Reservation> getCarsByIdUser(Long idUser) {

        return reservationRepository.findByUtilisateurId(idUser);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}




