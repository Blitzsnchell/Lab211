package Manager;

import Entity.History;
import View.Validate;
import Entity.Worker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WorkerController {
    private WorkerManager workerManager = new WorkerManager();

    public void addWorker() {
        System.out.print("Enter code: ");
        String id = Validate.checkInputString();
        System.out.print("Enter name: ");
        String name = Validate.checkInputString();
        System.out.print("Enter age: ");
        int age = Validate.checkInputIntLimit(18, 50);
        System.out.print("Enter salary: ");
        int salary = Validate.checkInputSalary();
        System.out.print("Enter work location: ");
        String workLocation = Validate.checkInputString();

        Worker newWorker = new Worker(id, name, age, salary, workLocation);
        if (workerManager.addWorker(newWorker)) {
            System.out.println("Add success.");
        } else {
            System.out.println("Worker with this ID already exists.");
        }
    }

    public void changeSalary(int status) {
        if (workerManager.getLstWorker().isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        System.out.print("Enter code: ");
        String id = Validate.checkInputString();
        Worker worker = workerManager.findWorkerById(id);
        if (worker == null) {
            System.out.println("Worker not found.");
            return;
        }

        int currentSalary = worker.getSalary();
        int newSalary;
        if (status == 1) { // Tăng lương
            System.out.print("Enter new salary: ");
            while (true) {
                newSalary = Validate.checkInputSalary();
                if (newSalary <= currentSalary) {
                    System.out.println("Must be greater than current salary. Enter again: ");
                } else {
                    break;
                }
            }
            workerManager.updateSalary(worker, newSalary, "UP", getCurrentDate());
        } else { // Giảm lương
            System.out.print("Enter new salary: ");
            while (true) {
                newSalary = Validate.checkInputSalary();
                if (newSalary >= currentSalary) {
                    System.out.println("Must be smaller than current salary. Enter again: ");
                } else {
                    break;
                }
            }
            workerManager.updateSalary(worker, newSalary, "DOWN", getCurrentDate());
        }
        System.out.println("Salary updated successfully.");
    }

    public void printListHistory() {
        if (workerManager.getLstHistory().isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        workerManager.getLstHistory().sort((h1, h2) -> h1.getDate().compareTo(h2.getDate()));

        for (History history : workerManager.getLstHistory()) {
            workerManager.printHistory(history);
        }
    }

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    
}
