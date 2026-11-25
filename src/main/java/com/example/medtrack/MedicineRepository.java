package com.example.medtrack;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository
        extends JpaRepository<Medicine, Long> {
}