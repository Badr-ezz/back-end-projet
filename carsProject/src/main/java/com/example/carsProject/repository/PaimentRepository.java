package com.example.carsProject.repository;

import com.example.carsProject.entity.Paiment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


@Repository
public interface PaimentRepository extends JpaRepository<Paiment, Long> {
}
