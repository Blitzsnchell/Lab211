package Main;


import Control.Management;
import View.InputData;
import View.Display;
import Model.Student;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> stuList = new ArrayList<>();
        // loop until user want to exist program
        while (true) {            
            // Step 1: Display menu
            Display.displayMenu();
            
            // Step 2: Input choice
            int choice = InputData.inputInteger("Your choice: ", 1, 5);
            
            // Step 3: Perform to request
            switch(choice){
                // 1. Create record student
                case 1:
                    Management.createRecordStudent(stuList);
                    break;

                // 2. Find and sort student by name
                case 2:
                    Management.findSortStudentByName(stuList);
                    break;

                // 3. Update or delete student by id
                case 3:
                    Management.updateDeleteStudentById(stuList);
                    break;

                // 4. Report student with total course
                case 4:
                    Management.reportStudentTotalCourse(stuList);
                    break;

                //5. Exit program
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}








/*
    1       thai        fall        java
    2       dung        spring      java
    1       thai        spring      java
    3       quan        summer      .net
    2       dung        fall        c/c++
    3       quan        summer      c/c++
    2       dung        fall        java
    4       trung       spring      .net
    11      thao        summer      c/c++
    4       trung       spring      java
    5       huong       fall        .net
*/