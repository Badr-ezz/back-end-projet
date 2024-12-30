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

import java.time.LocalDate;
import java.util.Date;
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

    @GetMapping("/count")
    public ResponseEntity<Long> countReservations() {
        return ResponseEntity.ok(reservationService.countReservations());
    }


    @GetMapping("/allReservations")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservation());
    }

    @GetMapping("/reservedcars/{id}")
    public ResponseEntity<List<Reservation>> getCarsByIdUser(@PathVariable Long id){
        return ResponseEntity.ok(reservationService.getCarsByIdUser(id));
    }



    @DeleteMapping("/deletereservation/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
        return ResponseEntity.ok("reservation deleted");
    }



    @GetMapping("/checkconflect/{idveh}/{dateDebut}/{dateFin}")
    public ResponseEntity<List<Reservation>> checkConflect(@PathVariable Long idveh, @PathVariable String dateDebut, @PathVariable String dateFin){
        System.out.println("date debut entered in parameter" + dateDebut);
        System.out.println("date fin entered in parameter" + dateFin);
        LocalDate  datedebut = LocalDate.parse(dateDebut);
        LocalDate  datefin = LocalDate.parse(dateFin);
        System.out.println(datedebut);
        System.out.println(datefin);
        return ResponseEntity.ok(reservationService.getConflictingReservations(idveh, datedebut, datefin));
    }

    @GetMapping("/reservecar/{idres}/{dateDebut}/{dateFin}")
    public ResponseEntity<Reservation> getReservationsByIdUser(@PathVariable Long idres, @PathVariable String dateDebut, @PathVariable String dateFin){
        System.out.println("acces here done ");
        LocalDate  datedebut = LocalDate.parse(dateDebut);
        LocalDate  datefin = LocalDate.parse(dateFin);
        return ResponseEntity.ok(reservationService.reservecar(idres,datedebut, datefin));
    }
}



