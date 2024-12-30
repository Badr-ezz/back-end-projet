package com.example.carsProject.controller;

import com.example.carsProject.entity.Paiment;
import com.example.carsProject.service.PaimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/paiment")
@CrossOrigin("*")
public class PaimentController {
    private final PaimentService paimentService;

    @GetMapping()
    public ResponseEntity<List<Paiment>> getAllPaiments() {
        return ResponseEntity.ok(paimentService.getallPaiment());
    }

    @PostMapping("/{idres}")
    public ResponseEntity<Paiment> addPaiment(@RequestBody Paiment paiment, @PathVariable Long idres) {
        return ResponseEntity.ok(paimentService.addPaiment(paiment, idres));
    }
}
