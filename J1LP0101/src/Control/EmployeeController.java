/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import View.DataGetter;
import Model.Employee;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class EmployeeController {

    EmployeeManager employeeList = new EmployeeManager();

    public void addEmployee() {
        String id;
        //loop until the ID is not duplicated 
        do {
            id = DataGetter.getString("Enter id: ", "^[a-zA-Z0-9]+$");
            //check duplicated
            if (employeeList.findById(id) != null) {
                System.out.println("Id is existed");
            } else {
                break;
            }
        } while (true);
        String firstName = DataGetter.getString("Enter first name: ", "^[a-zA-Z]+$");
        String lastName = DataGetter.getString("Enter last name: ", "^[a-zA-Z]+$");
        String phone = DataGetter.getString("Enter phone: ", "^[0-9]{10}$");
        String email = DataGetter.getString("Enter email: ", "^[a-zA-Z0-9_]+@[a-z]{2,6}.[a-z]{2,6}$");
        String address = DataGetter.getString("Enter address: ", "^[a-zA-Z0-9- ]+$");
        Date dob = DataGetter.getDate("Enter day of birth: ");
        String sex = DataGetter.getString("Input gender (M: Male or F: Female): ", "m|M|F|f").toUpperCase();
        Double salary = DataGetter.getDouble("Enter salary: ");
        String adency = DataGetter.getString("Enter adency: ", "^[a-zA-Z ]+$");
        try {
            employeeList.addEmployee(new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, adency));
            System.out.println("        Add employee successfully       ");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.printf("%-10s|%-15s|%-15s|%-15s|%-20s|%-15s|%-20s|%-10s|%-15s|%-15s\n",
                "ID", "First Name", "Last Name", "Phone", "Email", "Address",
                "Date Of Birth", "Gender", "Salary", "Egency");
        //loop for first element to last element in list
        for (int i = 0; i < employeeList.getEmployeeList().size(); i++) {
            System.out.println(employeeList.getEmployeeList().get(i).toString());
        }
    }

    public void displayMenuUpdate() {
        System.out.println("        Choose information of employee to update    ");
        System.out.println("        1. Update new ID                            ");
        System.out.println("        2. Update new first name                    ");
        System.out.println("        3. Update new last name                     ");
        System.out.println("        4. Update new phone number                  ");
        System.out.println("        5. Update new email                         ");
        System.out.println("        6. Update new address                       ");
        System.out.println("        7. Update new date of birth                 ");
        System.out.println("        8. Update new gender                        ");
        System.out.println("        9. Update new salary                        ");
        System.out.println("        10. Update new agency                       ");
        System.out.println("        11. Exit                                    ");
    }

    public void updateEmployees() {
        String id;
        int choice;
        //check list employee empty
        if (employeeList.getEmployeeList().isEmpty()) {
            System.out.println("List employee is empty");
            return;
        }
        id = DataGetter.getString("Enter id to update: ", "^[a-zA-Z0-9]+$");
        //check id exist or not
        if (employeeList.findById(id) == null) {
            System.out.println("ID does not exist in employee list");
        } else {
            int index = Integer.parseInt(employeeList.findById(id).getId());
            do {
                displayMenuUpdate();
                choice = DataGetter.getOption(1, 11);
                switch (choice) {
                    case 1:
                        String newId;
                        do {
                            newId = DataGetter.getString("Enter new id: ", "^[a-zA-Z0-9]+$");
                            //check duplicated
                            if (employeeList.findById(newId) != null || id.equalsIgnoreCase(newId)) {
                                System.out.println("Id is existed");
                            } else {
                                break;
                            }
                        } while (true);
                        employeeList.findById(index + "").setId(newId);
                        index = Integer.parseInt(newId);
                        System.out.println("        Update id successfully!");
                        break;
                    case 2:
                        String newFirstName = DataGetter.getString("Enter new first name: ", "^[a-zA-Z]+$");
                        employeeList.findById(index + "").setFirstName(newFirstName);
                        System.out.println("        Update first name successfully!");
                        break;
                    case 3:
                        String newLastName = DataGetter.getString("Enter new last name: ", "^[a-zA-Z]+$");
                        employeeList.findById(index + "").setLastName(newLastName);
                        System.out.println("        Update last name successfully!");
                        break;
                    case 4:
                        String newPhone = DataGetter.getString("Enter new phone: ", "^[0-9]{10}$");
                        employeeList.findById(index + "").setPhone(newPhone);
                        System.out.println("        Update phone successfully!");
                        break;
                    case 5:
                        String newEmail = DataGetter.getString("Enter new email: ", "^[a-zA-Z0-9_]+@[a-z]{2,6}.[a-z]{2,6}$");
                        employeeList.findById(index + "").setEmail(newEmail);
                        System.out.println("        Update email successfully!");
                        break;
                    case 6:
                        String newAddress = DataGetter.getString("Enter new address: ", "^[a-zA-Z0-9- ]+$");
                        employeeList.findById(index + "").setAddress(newAddress);
                        System.out.println("        Update address successfully!");
                        break;
                    case 7:
                        Date newDob = DataGetter.getDate("Enter new day of birth: ");
                        employeeList.findById(index + "").setDob(newDob);
                        System.out.println("        Update day of birth successfully!");
                        break;
                    case 8:
                        String newSex = DataGetter.getString("Input new gender (M: Male or F: Female): ", "m|M|F|f").toUpperCase();
                        employeeList.findById(index + "").setSex(newSex);
                        System.out.println("        Update gender successfully!");
                        break;
                    case 9:
                        Double newSalary = DataGetter.getDouble("Enter new salary: ");
                        employeeList.findById(index + "").setSalary(newSalary);
                        System.out.println("        Update salary successfully!");
                        break;
                    case 10:
                        String newAdency = DataGetter.getString("Enter new adency: ", "^[a-zA-Z ]+$");
                        employeeList.findById(index + "").setAdency(newAdency);
                        System.out.println("        Update adency successfully!");
                        break;
                    case 11:
                        System.out.println("        Exit        ");
                        break;
                }

            } while (choice != 11);
            System.out.printf("%-10s|%-15s|%-15s|%-15s|%-20s|%-15s|%-20s|%-10s|%-15s|%-15s\n",
                    "ID", "First Name", "Last Name", "Phone", "Email", "Address",
                    "Date Of Birth", "Gender", "Salary", "Egency");
            for (int i = 0; i < employeeList.getEmployeeList().size(); i++) {
                System.out.println(employeeList.getEmployeeList().get(i).toString());
            }
        }

    }

    public void reremoveEmployee() {
        String id;
        //check list employee empty
        if (employeeList.getEmployeeList().isEmpty()) {
            System.out.println("List employee is empty");
        } else {
            //loop until found remove id in list
            do {
                id = DataGetter.getString("Enter id to remove: ", "^[a-zA-Z0-9]+$");
                if (employeeList.findById(id) == null) {
                    System.out.println("ID does not exist in employee list");
                } else {
                    employeeList.deleteEmployee(id);
                    break;
                }
            } while (true);
        }
        System.out.println("        Remove employee successfully       ");
        System.out.printf("%-10s|%-15s|%-15s|%-15s|%-20s|%-15s|%-20s|%-10s|%-15s|%-15s\n",
                "ID", "First Name", "Last Name", "Phone", "Email", "Address",
                "Date Of Birth", "Gender", "Salary", "Egency");
        //loop for first element to last element in list
        for (int i = 0; i < employeeList.getEmployeeList().size(); i++) {
            System.out.println(employeeList.getEmployeeList().get(i).toString());
        }
    }

    //Sort employees by salary
    public void sortEmployeeBySalary() {
        ArrayList<Employee> list = employeeList.getEmployeeList();

        if (list.isEmpty()) {
            System.out.println("List employee is empty");
            return;
        }

        // Sắp xếp theo lương tăng dần
        list.sort(Comparator.comparingDouble(Employee::getSalary));

        System.out.println("        Sort employee by salary successfully       ");
        System.out.printf("%-10s|%-15s|%-15s|%-15s|%-20s|%-15s|%-20s|%-10s|%-15s|%-15s\n",
                "ID", "First Name", "Last Name", "Phone", "Email", "Address",
                "Date Of Birth", "Gender", "Salary", "Agency");

        for (Employee e : list) {
            System.out.println(e);
        }
    }

    //Search employees
    public void searchInformationByName() {
        //Check list is emty
        if (employeeList.getEmployeeList().isEmpty()) {
            System.out.println("List employee is empty");
        } else {
            String searchName = DataGetter.getString("Enter search name: ", "^[a-zA-Z ]+$");
            boolean check = false;
            //loop for first contry to last country in list
            for (int i = 0; i < employeeList.getEmployeeList().size(); i++) {
                String name = employeeList.getEmployeeList().get(i).getFirstName() + " " + employeeList.getEmployeeList().get(i).getLastName();
                if (name.toUpperCase().contains(searchName.toUpperCase())) {
                    check = true;
                }
            }
            //case: found employee
            if (check == true) {
                System.out.printf("%-10s|%-15s|%-15s|%-15s|%-20s|%-15s|%-20s|%-10s|%-15s|%-15s\n",
                        "ID", "First Name", "Last Name", "Phone", "Email", "Address",
                        "Date Of Birth", "Gender", "Salary", "Egency");
                for (int i = 0; i < employeeList.getEmployeeList().size(); i++) {
                    String name = employeeList.getEmployeeList().get(i).getFirstName() + " " + employeeList.getEmployeeList().get(i).getLastName();
                    if (name.toUpperCase().contains(searchName.toUpperCase())) {
                        System.out.println(employeeList.getEmployeeList().get(i).toString());
                    }
                }
                //Case: Can't found employee
            } else {
                System.out.println("        Can't find the employee in list       ");
            }
        }
    }

}
