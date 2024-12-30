package com.example.carsProject.service;


import com.example.carsProject.entity.Reservation;
import com.example.carsProject.entity.Vehicule;
import com.example.carsProject.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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



    public List<Reservation> getConflictingReservations(Long vehId, LocalDate startDate, LocalDate endDate) {
         return reservationRepository.findConflictingReservations(vehId, startDate, endDate);
    }

    public Reservation reservecar(Long idres, LocalDate startDate, LocalDate endDate) {
         Optional<Reservation> result = reservationRepository.findById(idres);
         Reservation reservation = null;
         if (result.isPresent()) {
             reservation = result.get();
             reservation.setStatus("reserve");
             reservation.setDateDebut(startDate);
             reservation.setDateFin(endDate);
             return reservationRepository.save(reservation);
         }
         return null;
    }
}




