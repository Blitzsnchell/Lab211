/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import View.DataGetter;
import Model.Employee;
import Control.EmployeeController;
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
        EmployeeController employeeManagement = new EmployeeController();
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
                    employeeManagement.addEmployee();
                    break;
                //Update employees
                case 2:
                    employeeManagement.updateEmployees();
                    break;
                //Remove employees 
                case 3:
                    employeeManagement.reremoveEmployee();
                    break;
                //Search employees
                case 4:
                    employeeManagement.searchInformationByName();
                    break;
                //Sort employees by salary   
                case 5:
                    employeeManagement.sortEmployeeBySalary();
                    break;
                //Exit program
                case 6:
                    System.out.println("        Exit        ");
                    break;
            }
                       
        }while(option!=6);
    }
    
}
