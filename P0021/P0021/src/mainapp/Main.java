package mainapp;

import controller.Manager;
import controller.Validation;
import java.util.ArrayList;
import model.Report;
import model.Student;
import view.View;

/**
 *
 * @author Admin
 */
public class Main {

    Manager manager = new Manager();
    View view = new View();

    public void execute() {
        int choice;
        do {
            view.display();
            choice = Validation.getInt("Choose: ", 1, 5);
            switch (choice) {
                case 1:
                    while (manager.students.size() < 10) {
                        Student student = view.inputStudent(manager);
                        manager.createStudent(student.getId(), student.getStudentName(), student.getSemester(), student.getCourseName());
                        if (!Validation.getInputYN("Do you want to continue (Y/N): ")) {
                            break;
                        }
                    }

                    break;
                case 2:
                    if (manager.students.isEmpty()) {
                        System.err.println("Empty list");
                    } else {
                        String studentName = Validation.getString("Enter name to search: ");
                        ArrayList<Student> res = manager.studentsListFindByName(studentName);
                        manager.sort(res);
                        view.displayStudentsList(res);
                    }
                    break;
                case 3:
                    if (manager.students.isEmpty()) {
                        System.err.println("Empty list");
                    } else {
                        String id = Validation.getString("Enter id: ");
                        ArrayList<Student> studentsListFindById = manager.studentListFindById(id);
                        if (studentsListFindById.isEmpty()) {
                            System.err.println("Not found");
                        } else {
                            String name = null, semester = null, course = null;
                            view.displayStudentsList(studentsListFindById);
                            int number = Validation.getInt("Enter number: ", 1, studentsListFindById.size());
                            if (Validation.getInputUD("Do you want to update (U) or delete (D) student: ")) {                                        
                                name = Validation.getString("Enter student name: ").toUpperCase();                
                                semester = Validation.getString("Enter semester: ").toUpperCase();                
                                course = Validation.getInputCourse("Enter name course: ").toUpperCase();   
                                manager.updateOrDelete(studentsListFindById, id, name, semester, course, 1, number);
                            } else {
                                manager.updateOrDelete(studentsListFindById, id, name, semester, course, 2, number);
                            }
                            
                        }
                    }
                    break;
                case 4:
                    if (manager.students.isEmpty()) {
                        System.err.println("Empty list");
                    } else {
                        ArrayList<Report> reports = new ArrayList<>();
                        manager.report(reports);
                        view.displayReportsList(reports);
                    }
                    break;
                case 5:
                    return;
            }

            System.out.println();
        } while (choice != 5);
    }

    public static void main(String[] args) {
        new Main().execute();
    }

}
