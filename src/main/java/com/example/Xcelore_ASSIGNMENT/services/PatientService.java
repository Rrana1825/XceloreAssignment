package com.example.Xcelore_ASSIGNMENT.services;

import com.example.Xcelore_ASSIGNMENT.entity.Patient;
import com.example.Xcelore_ASSIGNMENT.respository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void removePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }

    public Patient getPatient(Long patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }
}
