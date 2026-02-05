package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.repository.DoctorRepository;
import com.edutech.progressive.service.DoctorService;

@Service
public class DoctorServiceImplJpa implements DoctorService{

    DoctorRepository dr;

    public DoctorServiceImplJpa(DoctorRepository dr) {
        this.dr = dr;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return dr.findAll();
    }

    @Override
    public Integer addDoctor(Doctor doctor) {
        Doctor doc = dr.save(doctor);
        return doc.getDoctorId();
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() {
        List<Doctor> doctors = dr.findAll();
        Collections.sort(doctors, Comparator.comparing(Doctor::getYearsOfExperience));
        return doctors;
    }

    public void updateDoctor(Doctor doctor) { 
        Doctor doc = getDoctorById(doctor.getDoctorId());
        doc.setFullName(doctor.getFullName());
        doc.setContactNumber(doctor.getContactNumber());
        doc.setEmail(doctor.getEmail());
        doc.setSpecialty(doctor.getSpecialty());
        doc.setYearsOfExperience(doctor.getYearsOfExperience());
        // doc.setClinics(doctor.getClinics());
        dr.save(doc);
    }

    public void deleteDoctor(int doctorId) { 
        dr.deleteById(doctorId);
    }

    public Doctor getDoctorById(int doctorId) { 
        return dr.findByDoctorId(doctorId); 
    }

}