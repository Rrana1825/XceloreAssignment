package com.example.Xcelore_ASSIGNMENT.controller;

import com.example.Xcelore_ASSIGNMENT.entity.Patient;
import com.example.Xcelore_ASSIGNMENT.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.addPatient(patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removePatient(@PathVariable Long id) {
        patientService.removePatient(id);
        return ResponseEntity.ok("Patient Deleted Sucessfully");
    }
}

