package com.edutech.progressive.service.impl;


import java.sql.SQLException;
import java.util.List;

import com.edutech.progressive.dao.ClinicDAOImpl;
import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.service.ClinicService;

public class ClinicServiceImplJdbc implements ClinicService{

    private ClinicDAOImpl cd;

    public ClinicServiceImplJdbc(ClinicDAOImpl cd) {
        this.cd = cd;
    }

    @Override
    public List<Clinic> getAllClinics(){
        try {
            return cd.getAllClinics();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Clinic getClinicById(int clinicId) {
        try {
            return cd.getClinicById(clinicId);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Integer addClinic(Clinic clinic) {
        try {
            return cd.addClinic(clinic);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void updateClinic(Clinic clinic) {
        try {
            cd.updateClinic(clinic);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
        }
    }

    @Override
    public void deleteClinic(int clinicId) {
        try {
            cd.deleteClinic(clinicId);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
        }
    }

}