/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Employee;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Fpt
 */
public class EmployeeManager {
    private ArrayList<Employee> lstEmployee;

    public EmployeeManager() {
        lstEmployee = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return new ArrayList<>(lstEmployee);
    }

    public Employee findById(String EmployeeID) {
        Employee Employee;
        EmployeeID = EmployeeID.toLowerCase().trim();
        for (int i = 0; i < lstEmployee.size(); i++) {
            Employee = lstEmployee.get(i);
            if (Employee.getId().toLowerCase().equals(EmployeeID)) {
                return Employee;
            }
        }
        return null;
    }

    public void addEmployee(Employee Employee) throws Exception {
        if (findById(Employee.getId()) == null) {
            lstEmployee.add(Employee);
        } else {
            throw new Exception("EmployeeID is existed");
        }
    }
    
    public ArrayList sort() {
        ArrayList<Employee> lst = new ArrayList<>(lstEmployee);
        Collections.sort(lst);
        return lst;
    }
    
    public void deleteEmployee(String id){
        lstEmployee.remove(findById(id));
    }
}
