package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.repository.PatientRepository;
import com.edutech.progressive.service.PatientService;

@Service
public class PatientServiceImplJpa implements PatientService{

    // @Autowired 
    PatientRepository pr;

    public PatientServiceImplJpa(PatientRepository pr) {
        this.pr = pr;
    }

    @Override
    public List<Patient> getAllPatients() {
        return pr.findAll();
        // return new ArrayList<>();
    }

    @Override
    public Integer addPatient(Patient patient) {
        Patient p = pr.save(patient);
        return p.getPatientId();
        // return -1;
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
        // return new ArrayList<>();
        List<Patient> pateints = pr.findAll();
        Collections.sort(pateints, Comparator.comparing(Patient::getFullName));
        return pateints;
    }

    public void updatePatient(Patient patient) {
        Patient p = getPatientById(patient.getPatientId());
        // p.setPatientId(patient.getPatientId());
        p.setFullName(patient.getFullName());
        p.setDateOfBirth(patient.getDateOfBirth());
        p.setAddress(patient.getAddress());
        p.setEmail(patient.getEmail());
        p.setContactNumber(patient.getContactNumber());
        pr.save(p);
    }

    public void deletePatient(int patientId) {
        pr.deleteById(patientId);
    }

    public Patient getPatientById(int patientId) {
        return pr.findByPatientId(patientId);
    }

}