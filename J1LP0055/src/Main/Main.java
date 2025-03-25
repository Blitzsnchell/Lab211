/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Entity.Doctor;
import Manager.DoctorContoller;
import Manager.Manager;
import View.ViewDoctor;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DoctorContoller controller = new DoctorContoller();
        while (true) {
            int choice = ViewDoctor.menu();
            switch (choice) {
                case 1:
                    controller.addDoctor();
                    break;
                case 2:
                    controller.updateDoctor();
                    break;
                case 3:
                    controller.deleteDoctor();
                    break;
                case 4:
                    controller.searchDoctor();
                    break;
                case 5:
                    return;
            }

        }

    }
}
