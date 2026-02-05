package com.edutech.progressive;

import java.sql.ClientInfoStatus;
import java.sql.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;

import com.edutech.progressive.dao.ClinicDAOImpl;
import com.edutech.progressive.dao.PatientDAOImpl;
import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.impl.ClinicServiceImplJdbc;
import com.edutech.progressive.service.impl.PatientServiceImplArraylist;
import com.edutech.progressive.service.impl.PatientServiceImplJdbc;

@SpringBootApplication
public class MediConnectApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to MediConnect Progressive Project!");

        // ClinicDAOImpl cd = new ClinicDAOImpl();
        // ClinicServiceImplJdbc cs = new ClinicServiceImplJdbc(cd);
        // Clinic clinic = new Clinic(0, "Amaya","pune", 0, "1234567890",2003);
        // cs.addClinic(clinic);
        // List<Clinic> clist = cs.getAllClinics();
        // for(Clinic c : clist){
        //     System.out.println(c);
        // }
    }
}
