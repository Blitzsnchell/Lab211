package View;


import Model.Report;
import Model.Student;
import java.util.ArrayList;

public class Display {
    public static void displayMenu() {
        System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
        System.out.println("\t1. Create");
        System.out.println("\t2. Find and Sort");
        System.out.println("\t3. Update/Delete");
        System.out.println("\t4. Report");
        System.out.println("\t5. Exit");
        System.out.println("(Please choose 1 to Create, 2 to Find and Sort, "
                + "3 to Update/Delete, 4 to Report and 5 to Exit program).");
    }
    
    public static void displayFindSortList(ArrayList<Student> searchList) {
        System.out.printf("%-10s%-20s%-20s%-20s", "ID", "Student name", "Semester", "Course name");
        // loop to access the first object to the last object
        for (Student obj : searchList) {
            System.out.println();
            obj.display();
        }
        System.out.println();
    }
    
    public static void displaySearchList(ArrayList<Student> stuList){
        int num = 0;
        System.out.printf("%-10s%-10s%-20s%-20s%-20s", "Number", "ID", "Student name", "Semester", "Course name");
        // loop to access the first object to the last object
        for (Student obj : stuList) {
            num++;
            System.out.printf("\n%-10d", num);
            obj.display();
        }
        System.out.println();
    }

    public static void displayReportList(ArrayList<Report> reportList) {
        // loop to access the first object to the last object
        for (Report obj : reportList) {
            obj.display();
        }
        System.out.println();
    }
    
}
