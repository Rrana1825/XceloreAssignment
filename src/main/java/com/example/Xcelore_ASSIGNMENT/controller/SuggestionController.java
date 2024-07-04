package com.example.Xcelore_ASSIGNMENT.controller;

import com.example.Xcelore_ASSIGNMENT.entity.Doctor;
import com.example.Xcelore_ASSIGNMENT.entity.Patient;
import com.example.Xcelore_ASSIGNMENT.services.DoctorService;
import com.example.Xcelore_ASSIGNMENT.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<?> suggestDoctors(@PathVariable("id") Long patientId) {
        Patient patient = patientService.getPatient(patientId);
        if (patient == null) {
            return ResponseEntity.badRequest().body("Patient not found");
        }

        List<Doctor> doctors = doctorService.suggestDoctors(patient.getCity(), patient.getSymptom());
        if (doctors.isEmpty()) {
            if (!patient.getCity().equalsIgnoreCase("Delhi") &&
                    !patient.getCity().equalsIgnoreCase("Noida") &&
                    !patient.getCity().equalsIgnoreCase("Faridabad")) {
                return ResponseEntity.ok("We are still waiting to expand to your location");
            } else {
                return ResponseEntity.ok("There isn’t any doctor present at your location for your symptom");
            }
        }

        return ResponseEntity.ok(doctors);
    }
}

