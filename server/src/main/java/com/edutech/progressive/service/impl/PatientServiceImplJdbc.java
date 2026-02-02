package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.dao.PatientDAOImpl;
import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.PatientService;

public class PatientServiceImplJdbc implements PatientService{

    PatientDAOImpl pd;

    public PatientServiceImplJdbc(PatientDAOImpl pd) {
        this.pd = pd;
    }

    @Override
    public List<Patient> getAllPatients() {
        return pd.getAllPatients();
    }

    @Override
    public Integer addPatient(Patient patient) {
        return pd.addPatient(patient);
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
        List<Patient> patientList = pd.getAllPatients();
        Collections.sort(patientList, Comparator.comparing(Patient::getFullName));
        return patientList;
    }

    public void updatePatient(Patient patient){
        pd.updatePatient(patient);
    }

    public void deletePatient(int patientId){
        pd.deletePatient(patientId);
    }

    public Patient getPatientById(int patientId){
        return pd.getPatientById(patientId);
    }

}