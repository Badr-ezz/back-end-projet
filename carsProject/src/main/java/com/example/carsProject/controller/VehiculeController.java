package com.example.carsProject.controller;


import com.example.carsProject.entity.Vehicule;
import com.example.carsProject.service.VehiculeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VehiculeController {
    public final VehiculeService vehiculeService;

    // Compter le nombre total des vehicules
    @GetMapping("/count")
    public ResponseEntity<Long> countVehicules() {
        return ResponseEntity.ok(vehiculeService.countVehicule());
    }

    @GetMapping("/allVehicules")
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

    @DeleteMapping("/deleteVehicule/{id}")
    public void delete(@PathVariable Long id) {
        vehiculeService.deleteVehicule(id);
    }

    @PostMapping("/addVehicule")
    public Vehicule create(@RequestBody Vehicule vehicule) {
        System.out.println("vehicule" + vehicule);
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
    @GetMapping("/marques")
    public ResponseEntity<List<String>> getAllUniqueMarques() {
        return ResponseEntity.ok(vehiculeService.getAllUniqueMarques());
    }

    @GetMapping("/types")
    public ResponseEntity<List<String>> getAllUniqueTypes() {
        return ResponseEntity.ok(vehiculeService.getAllUniqueTypes());
    }

    @GetMapping("/annees")
    public ResponseEntity<List<Integer>> getAllUniqueAnnees() {
        List<Integer> annees = vehiculeService.getAllUniqueAnnees();
        return ResponseEntity.ok(annees != null ? annees : new ArrayList<>());
    }

    @GetMapping("/status")
    public ResponseEntity<List<String>> getAllUniqueStatus() {
        return ResponseEntity.ok(vehiculeService.getAllUniqueStatus());
    }



    @GetMapping("filtered")
    public List<Vehicule> getFilteredVehicules(
            @RequestParam(required = false) String marque,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer annee,
            @RequestParam(required = false) String disponibilite,
            @RequestParam(required = false) Float tarif) {
        return vehiculeService.getFilteredVehicules(marque, type, annee, disponibilite, tarif);
    }

}
