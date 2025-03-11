/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import View.Validate;
import Entity.History;
import Entity.Worker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class WorkerController {

    WorkerManager workerManager = new WorkerManager();

    //allow user add worker
    public void addWorker() {
        System.out.print("Enter code: ");
        String id = Validate.checkInputString();
//        if (!Validate.checkIdExist(lw, id)) {
//            System.out.println("Code(id) must be existed in DB.");
//            return;
//        }
        System.out.print("Enter name: ");
        String name = Validate.checkInputString();
        System.out.print("Enter age: ");
        int age = Validate.checkInputIntLimit(18, 50);
        System.out.print("Enter salary: ");
        int salary = Validate.checkInputSalary();
        System.out.print("Enter work location: ");
        String workLocation = Validate.checkInputString();
        if (!Validate.checkWorkerExist(workerManager.getLstWorker(), id, name, age, salary, workLocation)) {
            System.out.println("Duplicate.");
        } else {
            workerManager.getLstWorker().add(new Worker(id, name, age, salary, workLocation));
            System.out.println("Add success.");
        }
    }

    //allow user increase salary for user
    public void changeSalary(int status) {
        if (workerManager.getLstWorker().isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        System.out.print("Enter code: ");
        String id = Validate.checkInputString();
        Worker worker = workerManager.getWorkerByCode(id);
        if (worker == null) {
            System.out.println("Not exist worker.");
        } else {
            int salaryCurrent = worker.getSalary();
            int salaryUpdate;
            //check user want to update salary
            if (status == 1) {
                System.out.print("Enter salary: ");
                //loop until user input salary update > salary current
                while (true) {     
                    salaryUpdate = Validate.checkInputSalary();
                    //check user input salary update > salary current
                    if (salaryUpdate <= salaryCurrent) {
                        System.out.println("Must be greater than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                workerManager.getLstHistory().add(new History("UP", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            } else {
                System.out.print("Enter salary: ");
                //loop until user input salary update < salary current
                while (true) {
                    salaryUpdate = Validate.checkInputSalary();
                    //check user input salary update < salary current
                    if (salaryUpdate >= salaryCurrent) {
                        System.out.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                workerManager.getLstHistory().add(new History("DOWN", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            }
            worker.setSalary(salaryUpdate);
            System.out.println("Update success");
        }
    }

    //allow user print history
    public void printListHistory() {
        if (workerManager.getLstHistory().isEmpty()) {
        System.out.println("List empty.");
        return;
    }
    System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
            "Salary", "Status", "Date");

    // Sắp xếp theo ngày mà không cần implements Comparable
    workerManager.getLstHistory().sort((h1, h2) -> h1.getDate().compareTo(h2.getDate()));

    for (History history : workerManager.getLstHistory()) {
        printHistory(history);
    }
    }

    

    //get current date 
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    //print history
    public void printHistory(History history) {
        System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }
}
