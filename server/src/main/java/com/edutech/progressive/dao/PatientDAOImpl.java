package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Patient;

public class PatientDAOImpl implements PatientDAO{
    private Connection connection;

    public PatientDAOImpl(){
        try {
            this.connection = DatabaseConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addPatient(Patient patient) {
        String sql = "insert into patient(full_name, date_of_birth, contact_number, email, address) values(?,?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            
            ps.setString(1, patient.getFullName());
            ps.setDate(2,new Date(patient.getDateOfBirth().getTime()));
            ps.setString(3, patient.getContactNumber());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                patient.setPatientId(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return patient.getPatientId();
    }

    @Override
    public Patient getPatientById(int patientId) {
        String sql = "select * from patient where patient_id = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Patient(patientId, 
                    rs.getString("full_name"), 
                    new Date (rs.getDate("date_of_birth").getTime()), 
                    rs.getString("contact_number"), 
                    rs.getString("email"), 
                    rs.getString("address"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updatePatient(Patient patient) {
        String sql = "update patient set full_name =?, date_of_birth =?, contact_number =?, email =?, address =? where patient_id=?";

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setString(1, patient.getFullName());
            ps.setDate(2,new Date(patient.getDateOfBirth().getTime()));
            ps.setString(3, patient.getContactNumber());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());
            ps.setInt(6, patient.getPatientId());

            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deletePatient(int patientId) {
       String sql = "delete from patient where patient_id= ?";
       try(PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setInt(1, patientId);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patientList = new ArrayList<>();
        String sql = "select * from patient";
        try(PreparedStatement ps = connection.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient(rs.getInt("patient_id"), 
                    rs.getString("full_name"), 
                    new Date (rs.getDate("date_of_birth").getTime()), 
                    rs.getString("contact_number"), 
                    rs.getString("email"), 
                    rs.getString("address"));
                    
                    patientList.add(patient);
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return patientList;
    }

}
