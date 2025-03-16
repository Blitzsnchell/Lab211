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
public class DoctorContoller {
    private DoctorManager doctorManager = new DoctorManager();

    // Add a doctor
    public void addDoctor() {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        if (!Validate.checkCodeExist(doctorManager.getDoctorList(), code)) {
            System.out.println("Code exist.");
            return;
        }
        
        System.out.print("Enter name: ");
        String name = Validate.checkInputString();
        System.out.print("Enter specialization: ");
        String specialization = Validate.checkInputString();
        System.out.print("Enter availability: ");
        int availability = Validate.checkInputInt();
        
        try {
            doctorManager.addDoctor(new Doctor(code, name, specialization, availability));
            System.out.println("Add successful.");
        } catch (Exception e) {
            System.out.println("Duplicate.");
        }
    }

    // Update a doctor
    public void updateDoctor() {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        Doctor doctor = doctorManager.findByCode(code);
        
        if (doctor == null) {
            System.out.println("Not found doctor");
            return;
        }
        
        System.out.print("Enter code: ");
        String codeUpdate = Validate.checkInputString();
        System.out.print("Enter name: ");
        String name = Validate.checkInputString();
        System.out.print("Enter specialization: ");
        String specialization = Validate.checkInputString();
        System.out.print("Enter availability: ");
        int availability = Validate.checkInputInt();
        
        try {
            doctorManager.updateDoctor(code, codeUpdate, name, specialization, availability);
            System.out.println("Update successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete a doctor
    public void deleteDoctor() {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        try {
            doctorManager.deleteDoctor(code);
            System.out.println("Delete successful.");
        } catch (Exception e) {
            System.out.println("Not found doctor.");
        }
    }

    // Search doctors
    public void searchDoctor() {
        System.out.print("Enter name: ");
        String nameSearch = Validate.checkInputString();
        ArrayList<Doctor> foundDoctors = doctorManager.searchByName(nameSearch);
        
        if (foundDoctors.isEmpty()) {
            System.out.println("List empty.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : foundDoctors) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }
        }
    }
}
