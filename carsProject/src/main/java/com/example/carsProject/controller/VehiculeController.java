package com.example.carsProject.controller;


import com.example.carsProject.entity.Vehicule;
import com.example.carsProject.service.VehiculeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
public class VehiculeController {
    public final VehiculeService vehiculeService;

    @GetMapping
    public List<Vehicule> getAll() {
        return vehiculeService.getAllUVehicule();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculeService.getVehiculeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> update(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        return ResponseEntity.ok(vehiculeService.updateVehicule(id, vehicule));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vehiculeService.deleteVehicule(id);
    }

    @PostMapping
    public Vehicule create(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }


    @GetMapping("/bymarque")
    public ResponseEntity<List<Vehicule>> getByMarque(@RequestParam String marque){
        return ResponseEntity.ok(vehiculeService.getVehiculeByMarque(marque));
    }

    @GetMapping("/bymodele")
    public ResponseEntity<List<Vehicule>> getByModele(@RequestParam String modele){
        return ResponseEntity.ok(vehiculeService.getVehiculeByModele(modele));
    }

    @GetMapping("/byprixlessthan")
    public ResponseEntity<List<Vehicule>> getByPrixLessThan(@RequestParam float prix){
        return ResponseEntity.ok(vehiculeService.getVehiculeByPrixLessThan(prix));
    }

    @GetMapping("/vehiculetype")
    public ResponseEntity<List<Vehicule>> getByType(@RequestParam String type){
        return ResponseEntity.ok(vehiculeService.getVehiculeByType(type));
    }

    @GetMapping("/byStatus")
    public ResponseEntity<List<Vehicule>> getByStatus(@RequestParam String status){
        return ResponseEntity.ok(vehiculeService.getVehiculeByStatus(status));
    }

    @GetMapping("/byannee")
    public ResponseEntity<List<Vehicule>> getByAnnee(@RequestParam Integer annee){
        return ResponseEntity.ok(vehiculeService.getVehiculeByAnnee(annee));
    }
//    @DeleteMapping()
}
