package com.edutech.progressive.service.impl;


import java.util.List;

import com.edutech.progressive.dao.ClinicDAOImpl;
import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.service.ClinicService;

public class ClinicServiceImplJdbc implements ClinicService{

    ClinicDAOImpl cd;

    public ClinicServiceImplJdbc(ClinicDAOImpl cd) {
        this.cd = cd;
    }

    @Override
    public List<Clinic> getAllClinics() {
        return cd.getAllClinics();
    }

    @Override
    public Clinic getClinicById(int clinicId) {
        
        return cd.getClinicById(clinicId);
    }

    @Override
    public Integer addClinic(Clinic clinic) {
        return cd.addClinic(clinic);
    }

    @Override
    public void updateClinic(Clinic clinic) {
        cd.updateClinic(clinic);
    }

    @Override
    public void deleteClinic(int clinicId) {
        cd.deleteClinic(clinicId);
    }

}