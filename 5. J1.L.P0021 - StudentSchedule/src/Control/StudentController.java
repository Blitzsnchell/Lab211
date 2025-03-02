package Control;

import View.InputData;
import View.Display;
import Model.Report;
import Model.Student;
import java.util.ArrayList;
import java.util.Collections;

public class StudentController {

    StudentManager studentList = new StudentManager();

    public void createRecordStudent() {
        String id;
        String name;
        String semester;
        String course;
        // loop until user enter at least 5 information student
        while (true) {
            // loop until user enter legit id and name
            while (true) {
                id = InputData.inputString("\nEnter ID: ");
                name = InputData.inputString("Enter student name: ");
                // check legit id and name (one id has only one name)
                if (studentList.findById(id, name) != null) {
                    System.out.println("This ID was exist with another person.");
                    System.out.println("Enter again.");
                } else {
                    break;
                }
            }

            semester = InputData.inputString("Enter semester: ");
            course = InputData.inputCourseName("Enter course name: ");
            // check duplicate student's schedule
            if (studentList.checkDuplicateStudent(id, semester, course)) {
                System.out.println("This student's schedule existed.");
                System.out.println("Enter again");
                continue;
            }

            try {
                System.out.println("Add successfully!");
                studentList.addStudent(new Student(id, name, semester, course));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            // check minimum record number
            if (studentList.getStudentList().size() >= 5) {
                boolean choice = InputData.inputYN("\nDo you want to continue (Y/N)? ", "y", "n");
                if (!choice) {
                    return;
                }
            }
        }
    }

    public void findSortStudentByName() {
        // check empty list
        if (studentList.getStudentList().isEmpty()) {
            System.out.println("The list is empty.");
            System.out.println("Please add information.");
            return;
        }

        ArrayList<Student> searchList;
        String nameSearch;
        // loop until the name search is exist in list
        while (true) {
            nameSearch = InputData.inputString("Enter the student's name that you want to search: ");
            searchList = studentList.getListByNameSearch(nameSearch);
            // check empty list
            if (searchList.isEmpty()) {
                System.out.println("Don't have this name in list.");
                System.out.println("Please enter again.");
            } else {
                break;
            }
        }

        Collections.sort(searchList);
        Display.displayFindSortList(searchList);
    }

    public void updateDeleteStudentById() {
        // check empty list
        if (studentList.getStudentList().isEmpty()) {
            System.out.println("The list is empty.");
            System.out.println("Please add information.");
            return;
        }

        ArrayList<Student> searchList = new ArrayList<>();
        // loop until find id search in the list
        while (true) {
            String idSearch = InputData.inputString("Enter ID search: ");
            searchList = studentList.getListById(idSearch);
            // check empty list
            if (searchList.isEmpty()) {
                System.out.println("This id is not exist in list.");
                System.out.println("Enter again.");
            } else {
                break;
            }
        }

        Display.displaySearchList(searchList);
        int idNumber = 0;
        if (searchList.size() >= 2) {
            idNumber = InputData.inputInteger("Enter the number that "
                    + "you want to delete or update: ", 1, searchList.size());
            idNumber -= 1;
        }

        Student object = searchList.get(idNumber);
        boolean choice = InputData.inputYN("Do you want to update (U) or delete (D) student: ", "U", "D");

        int index = studentList.getIndexStudent(object);

        // Update (U) equal true and Delete(D) equal false
        if (choice) {
            String idNew;
            String nameNew;
            String semesterNew;
            String courseNew;

            studentList.deleteStudent(index + "");
            // loop until user enter legit student's schedule
            while (true) {
                // loop until user enter legit id and name
                while (true) {
                    idNew = InputData.inputString("\nEnter new ID: ");
                    nameNew = InputData.inputString("Enter new student's name: ");
                    // check legit id and name (one id has only one name)
                    if (studentList.checkDuplicateId(idNew, nameNew)) {
                        System.out.println("This ID was exist with another person.");
                        System.out.println("Enter again.");
                    } else {
                        break;
                    }
                }

                semesterNew = InputData.inputString("Enter new semester: ");
                courseNew = InputData.inputCourseName("Enter new course name: ");
                // check duplicate student's schedule
                if (studentList.checkDuplicateStudent(idNew, semesterNew, courseNew)) {
                    System.out.println("This student's schedule existed.");
                    System.out.println("Enter again");
                } else {
                    break;
                }
            }
            studentList.addStudentWithIndex(index, new Student(idNew, nameNew, semesterNew, courseNew));
            System.out.println("Update successful!");
        } else {
            studentList.deleteStudent(index + "");
            System.out.println("Delete successful!");
        }
    }

    public void reportStudentTotalCourse() {
        // check empty list
        if (studentList.getStudentList().isEmpty()) {
            System.out.println("The list is empty.");
            System.out.println("Please add information.");
            return;
        }

        ArrayList<Student> tempList = new ArrayList<>();
        ArrayList<Report> reportList = new ArrayList();
        tempList.addAll(studentList.getStudentList());

        /* loop to access the first object to the last object in list,
        after each loop, we can count the total course of one student */
        for (int i = 0; i < tempList.size(); i++) {
            Student stu1 = tempList.get(i);
            int num = 1;
            // loop to access the second object to the last object in list
            for (int j = i + 1; j < tempList.size(); j++) {
                Student stu2 = tempList.get(j);
                // Compare each pair (include id, course) between two objects
                if (stu1.getId().equalsIgnoreCase(stu2.getId())
                        && stu1.getCourse().equalsIgnoreCase(stu2.getCourse())) {
                    num++;
                    tempList.remove(j);
                    j--;
                }
            }
            reportList.add(new Report(stu1.getName(), stu1.getCourse(), num));
        }
        Display.displayReportList(reportList);
    }

    

}
