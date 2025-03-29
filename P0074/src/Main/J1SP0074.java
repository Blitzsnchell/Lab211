package Main;

import Controller.Manage;
import View.ViewCalculateMatrix;

public class J1SP0074 {

    public static void main(String[] args) {
        Manage mc = new Manage();
        ViewCalculateMatrix view = new ViewCalculateMatrix();
        while (true) {
            int choice = view.menu();

            if (choice == 4) {
                System.out.println("Exiting program...");
                break;
            }

            switch (choice) {
                case 1:
                    mc.add();
                    break;
                case 2:
                    mc.sub();
                    break;
                case 3:
                    mc.mul();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
