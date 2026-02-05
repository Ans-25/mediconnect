package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.impl.DoctorServiceImplJpa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    DoctorServiceImplJpa dsj;

    public DoctorController(DoctorServiceImplJpa dsj) {
        this.dsj = dsj;
    }

    @GetMapping()
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.status(200).body(dsj.getAllDoctors());
    }

    @GetMapping("/{doctorID}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int doctorID) {
        return ResponseEntity.status(200).body(dsj.getDoctorById(doctorID));
    }

    @PostMapping
    public ResponseEntity<Integer> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.status(201).body(dsj.addDoctor(doctor));
    }

    @PutMapping("/{doctorID}")
    public ResponseEntity<Void> updateDoctor(@PathVariable int doctorID, @RequestBody Doctor doctor) {
        dsj.updateDoctor(doctor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{doctorID}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable int doctorID) {
        dsj.deleteDoctor(doctorID);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/experience")
    public ResponseEntity<List<Doctor>> getDoctorSortedByExperience() {
        return ResponseEntity.status(200).body(dsj.getDoctorSortedByExperience());
    }
}
