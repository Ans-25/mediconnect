package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Doctor;

public class DoctorDAOImpl implements DoctorDAO{
    private Connection connection;

    public DoctorDAOImpl() {
        try {
            this.connection = DatabaseConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addDoctor(Doctor doctor) {
        String sql = "insert into doctor(full_name,specialty,contact_number,email,years_of_experience) values(?,?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            
            ps.setString(1, doctor.getFullName());
            ps.setString(2, doctor.getSpecialty());
            ps.setString(3, doctor.getContactNumber());
            ps.setString(4, doctor.getEmail());
            ps.setInt(5, doctor.getYearsOfExperience());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                doctor.setDoctorId(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return doctor.getDoctorId();
    }

    @Override
    public Doctor getDoctorById(int doctorId) {
        String sql = "select * from doctor where doctor_id = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Doctor(doctorId, 
                    rs.getString("full_name"), 
                    rs.getString("specialty"), 
                    rs.getString("contact_number"), 
                    rs.getString("email"), 
                    rs.getInt("years_of_experience"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        String sql = "update doctor set full_name =?, specialty =?, contact_number =?, email =?, years_of_experience =? where doctor_id=?";

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setString(1, doctor.getFullName());
            ps.setString(2, doctor.getSpecialty());
            ps.setString(3, doctor.getContactNumber());
            ps.setString(4, doctor.getEmail());
            ps.setInt(5, doctor.getYearsOfExperience());
            ps.setInt(6, doctor.getDoctorId());

            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDoctor(int doctorId) {
        String sql = "delete from doctor where doctor_id= ?";
       try(PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setInt(1, doctorId);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctorList = new ArrayList<>();
        String sql = "select * from doctor";
        try(PreparedStatement ps = connection.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Doctor doctor = new Doctor(rs.getInt("doctor_id"), 
                    rs.getString("full_name"), 
                    rs.getString("specialty"), 
                    rs.getString("contact_number"), 
                    rs.getString("email"), 
                    rs.getInt("years_of_experience"));
                    
                    doctorList.add(doctor);
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return doctorList;
    }



}
