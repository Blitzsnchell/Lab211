/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import View.DataGetter;
import Model.Employee;
import Control.EmployeeManagement;
import View.ViewEmployee;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        EmployeeManagement employeeManagement = new EmployeeManagement();
        ArrayList<Employee> listEmployees = new ArrayList<>();
        ViewEmployee view = new ViewEmployee();
        int option;
        //loop until user choose option 6 : exit
        do{
            //Display a menu
            ViewEmployee.displayMenu();
            //ask users to select an option
            option = DataGetter.getOption(1, 6);
            //Handle function based on user option
            switch (option) {
                //Add employees
                case 1:
                    employeeManagement.addEmployee(listEmployees);
                    break;
                //Update employees
                case 2:
                    employeeManagement.updateEmployees(listEmployees);
                    break;
                //Remove employees 
                case 3:
                    employeeManagement.reremoveEmployee(listEmployees);
                    break;
                //Search employees
                case 4:
                    employeeManagement.searchInformationByName(listEmployees);
                    break;
                //Sort employees by salary   
                case 5:
                    employeeManagement.sortEmployeeBySalary(listEmployees);
                    break;
                //Exit program
                case 6:
                    System.out.println("        Exit        ");
                    break;
            }
                       
        }while(option!=6);
    }
    
}
