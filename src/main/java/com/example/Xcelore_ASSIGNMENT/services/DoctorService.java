package com.example.Xcelore_ASSIGNMENT.services;

import org.springframework.stereotype.Service;
import com.example.Xcelore_ASSIGNMENT.respository.DoctorRepo;
import com.example.Xcelore_ASSIGNMENT.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Collections;
import com.example.Xcelore_ASSIGNMENT.Helper.Speciality;
import com.example.Xcelore_ASSIGNMENT.Helper.Symptom;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void removeDoctor(Long doctorId) {
        doctorRepository.deleteById(doctorId);
    }

    public List<Doctor> suggestDoctors(String city, Symptom symptom) {
        Speciality speciality = getSpecialityBySymptom(symptom);
        if (speciality == null) {
            return Collections.emptyList();
        }
        return doctorRepository.findByCityAndSpeciality(city, speciality);
    }

    private Speciality getSpecialityBySymptom(Symptom symptom) {
        return switch (symptom) {
            case ARTHRITIS, BACK_PAIN, TISSUE_INJURIES -> Speciality.ORTHOPAEDIC;
            case DYSMENORRHEA -> Speciality.GYNECOLOGY;
            case SKIN_INFECTION, SKIN_BURN -> Speciality.DERMATOLOGY;
            case EAR_PAIN -> Speciality.ENT;
            default -> null;
        };
    }
}
