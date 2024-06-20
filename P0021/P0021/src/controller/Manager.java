package controller;

import model.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import model.Report;

/**
 *
 * @author Admin
 */
public class Manager {    
    
    public ArrayList<Student> students = new ArrayList<>();
    //public ArrayList<Report> reports = new ArrayList<>();
   // public View view = new View();
    
    // Create new student
    public void createStudent(String id, String studentName, String semester, String courseName) {        
        students.add(new Student(id, studentName, semester, courseName));
    }
    
    // Find and sort
    public void sort(ArrayList<Student> list) {
        Collections.sort(list);
//        view.displayStudentsList(list);
    }

    public ArrayList<Student> studentsListFindByName(String studentName) {
        studentName = studentName.toUpperCase();
        ArrayList<Student> res = new ArrayList<>();
        for (Student s : students) {
            if (s.getStudentName().contains(studentName)) {
                res.add(s);
            }
        }
        return res;
    }

    // Update and delete   
    public void updateOrDelete(ArrayList<Student> studentsListFindById, String id, String name, String semester, String course, int mode, int number) {        
        Student student = getStudentByListFound(studentsListFindById, number);
        if (mode == 1) {
            if (!checkStudentExist(this, id, name, semester, course)) {
                for (Student s : studentsListFindById) {
                    s.setStudentName(name);
                }
                student.setSemester(semester);
                student.setCourseName(course);
            } 
        } else if (mode == 2) {
            students.remove(student);
            System.out.println("Delete success");
        }
    }

    Student getStudentByListFound(ArrayList<Student> studentList, int number) {
//        view.displayStudentsList(studentList);        
//        int choice = Validation.getInt("Enter student: ", 1, studentList.size());
        return studentList.get(number - 1);
    }

    public ArrayList<Student> studentListFindById(String id) {
        ArrayList<Student> res = new ArrayList<>();
        for (Student s : students) {
            if (id.equalsIgnoreCase(s.getId())) {
                res.add(s);
            }
        }
        return res;
    }
    
    public boolean checkStudentExist(Manager m, String id, String studentName, String semester, String courseName) {
        for (Student s : students) {
            if (studentName.equalsIgnoreCase(s.getStudentName())
                    && semester.equalsIgnoreCase(s.getSemester())
                    && courseName.equalsIgnoreCase(s.getCourseName())) {
                return true;
            }
        }
        return false;
    }    

    // Report
    public void report(ArrayList<Report> reports) {
        
        // key -> value
        HashMap<String, Integer> map = new HashMap<>();
        
        for (Student s : students) {
            String key = s.getStudentName() + "|" + s.getCourseName();
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            reports.add(new Report(key.split("[|]")[0], key.split("[|]")[1], entry.getValue()));
        }
    }
    
}
