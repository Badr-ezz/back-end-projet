package com.example.carsProject.controller;


import com.example.carsProject.entity.Reservation;
import com.example.carsProject.entity.Utilisateur;
import com.example.carsProject.entity.Vehicule;
import com.example.carsProject.service.ReservationService;
import com.example.carsProject.service.UtilisateurService;
import com.example.carsProject.service.VehiculeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservation")
@CrossOrigin("*")
public class ReservationController {
    private final ReservationService reservationService;
    private final UtilisateurService utilisateurService;
    private final VehiculeService vehiculeService;

    @PostMapping("/addreservation")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        System.out.println("reservation : " + reservation);
        return ResponseEntity.ok(reservationService.addReservation(reservation));
    }

    @GetMapping()
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservation());
    }

    @GetMapping("/reservedcars/{id}")
    public ResponseEntity<List<Reservation>> getCarsByIdUser(@PathVariable Long id){
        return ResponseEntity.ok(reservationService.getCarsByIdUser(id));
    }
}
