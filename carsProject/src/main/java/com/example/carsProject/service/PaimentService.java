package com.example.carsProject.service;


import com.example.carsProject.entity.Paiment;
import com.example.carsProject.entity.Reservation;
import com.example.carsProject.repository.PaimentRepository;
import com.example.carsProject.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaimentService {
    private final PaimentRepository paimentRepository;
    private final ReservationRepository reservationRepository;

    public Paiment addPaiment(Paiment paiment, Long reservationId) {
            Paiment newPaiment = paimentRepository.save(paiment);
            Optional<Reservation> reservationToUpdate = reservationRepository.findById(reservationId);
            if (reservationToUpdate.isPresent()) {
                Reservation reservation = reservationToUpdate.get();
                reservation.setPaiment(newPaiment);
                reservationRepository.save(reservation);
            }
            return newPaiment;
    }

    public List<Paiment> getallPaiment() {
        return  paimentRepository.findAll();
    }
}
