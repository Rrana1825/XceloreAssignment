package com.example.Xcelore_ASSIGNMENT.respository;

import com.example.Xcelore_ASSIGNMENT.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,Long> {
}
