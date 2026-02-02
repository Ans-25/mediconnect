package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.dao.DoctorDAOImpl;
import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.DoctorService;

public class DoctorServiceImplJdbc implements DoctorService{

    DoctorDAOImpl dd;

    public DoctorServiceImplJdbc(DoctorDAOImpl dd) {
        this.dd = dd;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return dd.getAllDoctors();
    }

    public Doctor getDoctorById(int doctorId){
        return dd.getDoctorById(doctorId);
    }

    @Override
    public Integer addDoctor(Doctor doctor) {
        return dd.addDoctor(doctor);
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() {
        List<Doctor> doctorList = dd.getAllDoctors();
        Collections.sort(doctorList, Comparator.comparing(Doctor::getYearsOfExperience));
        return doctorList;
    }

    public void updateDoctor(Doctor doctor){
        dd.updateDoctor(doctor);
    }

    public void deleteDoctor(int doctorId){
        dd.deleteDoctor(doctorId);
    }
}