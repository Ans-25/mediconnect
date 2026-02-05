package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.PatientService;
import com.edutech.progressive.service.impl.PatientServiceImplArraylist;
import com.edutech.progressive.service.impl.PatientServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    // @Autowired
    // PatientServiceImplArraylist ps;
    // @Autowired
    // @Qualifier("PatientJpa")

    PatientServiceImplArraylist psi;
    PatientServiceImplJpa psj;

    public PatientController(PatientServiceImplArraylist psi, PatientServiceImplJpa psj) {
        this.psi = psi;
        this.psj = psj;
    }

    @GetMapping()
    public ResponseEntity<List<Patient>> getAllPatients() {
        // List<Patient> patients = ps.getAllPatients();
        // if (patients == null || patients.isEmpty()) {
        // // return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        // return ResponseEntity.status(500).body(null);
        // }
        // return ResponseEntity.status(200).body(patients);

        return ResponseEntity.status(200).body(psj.getAllPatients());
    }

    @GetMapping("/{patientID}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int patientID) {
        // Patient patient = ps.getPatientById(patientId);
        // return (patient == null)
        //         ? ResponseEntity.status(500).body(null)
        //         : ResponseEntity.status(200).body(patient);
        return ResponseEntity.status(200).body(psj.getPatientById(patientID));
    }

    @PostMapping()
    public ResponseEntity<Integer> addPatient(@RequestBody Patient patient) {
        // return (patient == null)
        //         ? ResponseEntity.status(500).body(null)
        //         : ResponseEntity.status(200).body(ps.addPatient(patient));
        return ResponseEntity.status(200).body(psj.addPatient(patient));
    }

    @PutMapping("/{patientID}")
    public ResponseEntity<Void> updatePatient(@PathVariable int patientID, @RequestBody Patient patient) {
        // if (ps.getPatientById(patientId) == null) {
        //     return ResponseEntity.status(500).build();
        // }
        // patient.setPatientId(patientId);
        psj.updatePatient(patient);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{patientID}")
    public ResponseEntity<Void> deletePatient(@PathVariable int patientID) {
        // if (ps.getPatientById(patientId) == null) {
        //     return ResponseEntity.status(500).build();
        // }
        // ps.deletePatient(patientId);
        // return ResponseEntity.status(401).build();
        psj.deletePatient(patientID);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Patient>> getAllPatientFromArrayList() {
        return ResponseEntity.ok().body(psi.getAllPatients());
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Void> addPatientToArrayList() {
        psi.addPatient(null);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<Patient>> getAllPatientSortedByNameFromArrayList() {
        return ResponseEntity.status(200).body(psi.getAllPatientSortedByName());
    } 
}