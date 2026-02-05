package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.service.impl.ClinicServiceImplJpa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/clinic")
public class ClinicController {

    ClinicServiceImplJpa csj;

    public ClinicController(ClinicServiceImplJpa csj) {
        this.csj = csj;
    }

    @GetMapping()
    public ResponseEntity<?> getAllClinics(){
        return ResponseEntity.status(200).body(csj.getAllClinics());
    }

    @GetMapping("/{clinicID}")
    public ResponseEntity<Clinic> getClinicById(@PathVariable int clinicID) {
        return ResponseEntity.status(200).body(csj.getClinicById(clinicID));
    }

    @PostMapping()
    public ResponseEntity<Integer> addClinic(@RequestBody Clinic clinic) {
        return ResponseEntity.status(201).body(csj.addClinic(clinic));
    }

    @PutMapping("/{clinicID}")
    public ResponseEntity<Void> updateClinic(@PathVariable int clinicID, @RequestBody Clinic clinic) {
        csj.updateClinic(clinic);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{clinicID}")
    public ResponseEntity<Void> deleteClinic(@PathVariable int clinicID) {
        csj.deleteClinic(clinicID);
        return ResponseEntity.status(401).build();
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<Clinic>> getAllClinicByLocation(@PathVariable String location) {
        return ResponseEntity.status(200).body(csj.getAllClinicByLocation(location));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Clinic>> getAllClinicByDoctorId(@PathVariable int doctorId) {
        return ResponseEntity.status(200).body(csj.getAllClinicByDoctorId(doctorId));
    }
}
