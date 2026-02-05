package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.repository.ClinicRepository;
import com.edutech.progressive.repository.DoctorRepository;
import com.edutech.progressive.service.ClinicService;

@Service
public class ClinicServiceImplJpa implements ClinicService {

    private ClinicRepository cr;
    // DoctorRepository dr;

    public ClinicServiceImplJpa(ClinicRepository cr) {
        this.cr = cr;
    }

    @Override
    public List<Clinic> getAllClinics(){
        return cr.findAll();
    }

    @Override
    public Clinic getClinicById(int clinicId) {
        return cr.findByClinicId(clinicId);
    }

    @Override
    public Integer addClinic(Clinic clinic) {
        Clinic cl = cr.save(clinic);
        return cl.getClinicId();
    }

    @Override
    public void updateClinic(Clinic clinic) {
        Clinic cl = getClinicById(clinic.getClinicId());
        cl.setClinicName(clinic.getClinicName());
        cl.setContactNumber(clinic.getContactNumber());
        cl.setDoctorId(clinic.getDoctorId());
        cl.setDoctor(clinic.getDoctor());
        cl.setEstablishedYear(clinic.getEstablishedYear());
        cl.setLocation(clinic.getLocation());

        cr.save(cl);
    }

    @Override
    public void deleteClinic(int clinicId) {
        cr.deleteById(clinicId);
    }

    public List<Clinic> findAllByLocation(String location){
        return cr.findAllByLocation(location);
    }

    public List<Clinic> findAllClinicByDoctorId(int doctorId){
        return cr.findAllByDoctorId(doctorId);
    }

}