/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import Entity.Doctor;
import View.Validate;
import java.util.ArrayList;

/**
 *
 * @author Fpt
 */
public class DoctorManager {
    private ArrayList<Doctor> doctorList;

    public DoctorManager() {
        doctorList = new ArrayList<>();
    }

    // Get doctor list
    public ArrayList<Doctor> getDoctorList() {
        return new ArrayList<>(doctorList);
    }

    // Find doctor by code
    public Doctor findByCode(String code) {
        for (Doctor doctor : doctorList) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    // Add doctor
    public void addDoctor(Doctor doctor) throws Exception {
        if (!Validate.checkCodeExist(doctorList, doctor.getCode()) || 
            !Validate.checkDuplicate(doctorList, doctor.getCode(), 
            doctor.getName(), doctor.getSpecialization(), doctor.getAvailability())) {
            throw new Exception("Doctor exists or duplicate");
        }
        doctorList.add(doctor);
    }

    // Update doctor
    public void updateDoctor(String oldCode, String newCode, String name, 
                           String specialization, int availability) throws Exception {
        Doctor doctor = findByCode(oldCode);
        if (doctor == null) {
            throw new Exception("Doctor not found");
        }
        if (Validate.checkChangeInfo(doctor, oldCode, name, specialization, availability)) {
            doctor.setCode(newCode);
            doctor.setName(name);
            doctor.setSpecialization(specialization);
            doctor.setAvailability(availability);
        } else {
            throw new Exception("No change");
        }
    }

    // Delete doctor
    public void deleteDoctor(String code) throws Exception {
        Doctor doctor = findByCode(code);
        if (doctor == null) {
            throw new Exception("Doctor not found");
        }
        doctorList.remove(doctor);
    }

    // Search by name
    public ArrayList<Doctor> searchByName(String name) {
        ArrayList<Doctor> foundDoctors = new ArrayList<>();
        for (Doctor doctor : doctorList) {
            if (doctor.getName().toLowerCase().contains(name.toLowerCase())) {
                foundDoctors.add(doctor);
            }
        }
        return foundDoctors;
    }
}
