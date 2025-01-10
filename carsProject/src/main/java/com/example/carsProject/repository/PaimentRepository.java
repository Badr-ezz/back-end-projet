package com.example.carsProject.repository;

import com.example.carsProject.entity.Paiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaimentRepository extends JpaRepository<Paiment, Long> {
}
