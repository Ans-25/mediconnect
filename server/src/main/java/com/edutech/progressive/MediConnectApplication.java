package com.edutech.progressive;

import java.sql.Date;

import com.edutech.progressive.dao.PatientDAOImpl;
import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.impl.PatientServiceImplArraylist;
import com.edutech.progressive.service.impl.PatientServiceImplJdbc;

public class MediConnectApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to MediConnect Progressive Project!");

        // PatientDAOImpl pd = new PatientDAOImpl();
        // PatientServiceImplJdbc ps = new PatientServiceImplJdbc(pd);
        // Patient patient = new Patient(0, "Amruta Shinde", Date.valueOf("12-06-2003"), "1234567890", "Amruta@123gamil.com", "paune");
        // ps.addPatient(patient);
        // for(Patient p : ps.getAllPatients()){
        // System.out.println(p);
        // }
    }
}
