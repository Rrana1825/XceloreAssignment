package com.example.Xcelore_ASSIGNMENT.respository;

import com.example.Xcelore_ASSIGNMENT.Helper.Speciality;
import com.example.Xcelore_ASSIGNMENT.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {
    List<Doctor> findByCityAndSpeciality(String city, Speciality speciality);
}
