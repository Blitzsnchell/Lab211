/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Entity.History;
import Entity.Worker;
import Manager.WorkerController;
import View.View;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        WorkerController workerController = new WorkerController();
        while (true) {
            int choice = View.menu();
            switch (choice) {
                case 1:
                    workerController.addWorker();
                    break;
                case 2:
                    workerController.changeSalary(1);
                    break;
                case 3:
                    workerController.changeSalary(2);
                    break;
                case 4:
                    workerController.printListHistory();
                    break;
                case 5:
                    return;
            }
        }
    }
}
