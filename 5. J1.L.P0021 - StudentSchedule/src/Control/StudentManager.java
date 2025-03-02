/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Student;
import java.util.ArrayList;

/**
 *
 * @author Fpt
 */
public class StudentManager {
    private ArrayList<Student> lstStudent;

    public StudentManager() {
        lstStudent = new ArrayList<Student>();
    }

    public ArrayList<Student> getStudentList() {
        return new ArrayList<>(lstStudent);
    }

    public Student findById(String id, String name) {
        Student Student;
        id = id.toLowerCase().trim();
        for (int i = 0; i < lstStudent.size(); i++) {
            Student = lstStudent.get(i);
            if (Student.getId().toLowerCase().equals(id) && Student.getName().toLowerCase().equals(name)) {
                return Student;
            }
        }
        return null;
    }

    public void addStudent(Student Student) throws Exception {
        if (findById(Student.getId(), Student.getName()) == null) {
            lstStudent.add(Student);
        } else {
            throw new Exception("StudentID is existed");
        }
    }
    
    public void addStudentWithIndex(int index, Student Student){
        lstStudent.add(index, Student);
        
    }
    
    public void deleteStudent(String id){
        for (int i = 0; i < lstStudent.size(); i++) {
            // compare between each information of input object and each object in list
            if (lstStudent.get(i).getId().equalsIgnoreCase(id)) {
                lstStudent.remove(i + 1);
            }
        }
    }
    
    
    public boolean checkDuplicateId(String id, String name) {
        // loop to access the first object to the last object
        for (Student obj : lstStudent) {
            // compare between id, name in input and id, name of each object 
            if (obj.getId().equalsIgnoreCase(id)
                    && !obj.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDuplicateStudent(String id, String semester, String course) {
        // loop to access the first object to the last object
        for (Student obj : lstStudent) {
            if (obj.getId().equalsIgnoreCase(id)
                    && obj.getSemester().equalsIgnoreCase(semester)
                    && obj.getCourse().equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getListByNameSearch(String nameSearch) {
        ArrayList<Student> searchList = new ArrayList<>();
        // loop to access the first object to the last object
        for (Student obj : lstStudent) {
            // compare between name search and name of each object in list
            if (obj.getName().toLowerCase().contains(nameSearch.toLowerCase())) {
                searchList.add(new Student(obj.getId(), obj.getName(), obj.getSemester(), obj.getCourse()));
            }
        }
        return searchList;
    }

    public ArrayList<Student> getListById(String idSearch) {
        ArrayList<Student> searchList = new ArrayList<>();
        // loop to access the first object to the last object
        for (Student obj : lstStudent) {
            if (obj.getId().equalsIgnoreCase(idSearch)) {
                searchList.add(new Student(obj.getId(), obj.getName(), obj.getSemester(), obj.getCourse()));
            }
        }
        return searchList;
    }

    public int getIndexStudent(Student object) {
        // loop to access the first object to the last object
        for (int i = 0; i < lstStudent.size(); i++) {
            // compare between each information of input object and each object in list
            if (lstStudent.get(i).getId().equalsIgnoreCase(object.getId())
                    && lstStudent.get(i).getSemester().equalsIgnoreCase(object.getSemester())
                    && lstStudent.get(i).getCourse().equalsIgnoreCase(object.getCourse())) {
                return i;
            }
        }
        return -1;
    }
}
