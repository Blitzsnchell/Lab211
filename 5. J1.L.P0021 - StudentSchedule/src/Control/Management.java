package Control;


import View.InputData;
import View.Display;
import Model.Report;
import Model.Student;
import java.util.ArrayList;
import java.util.Collections;

public class Management {
    public static void createRecordStudent(ArrayList<Student> stuList) {
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
                if(checkDuplicateId(id, name, stuList)){
                    System.out.println("This ID was exist with another person.");
                    System.out.println("Enter again.");
                }else   break;
            }

            semester = InputData.inputString("Enter semester: ");
            course = InputData.inputCourseName("Enter course name: ");
            // check duplicate student's schedule
            if(checkDuplicateStudent(id, semester, course, stuList)){
                System.out.println("This student's schedule existed.");
                System.out.println("Enter again");
                continue;
            }
            
            System.out.println("Add successfully!");
            stuList.add(new Student(id, name, semester, course));     
            // check minimum record number
            if(stuList.size() >= 5){
                boolean choice = InputData.inputYN("\nDo you want to continue (Y/N)? ", "y", "n");
                if(!choice) return;
            }
        }
    }
    
    public static void findSortStudentByName(ArrayList<Student> stuList) {
        // check empty list
        if(stuList.isEmpty()){
            System.out.println("The list is empty.");
            System.out.println("Please add information.");
            return;
        }
        
        ArrayList<Student> searchList;
        String nameSearch;
        // loop until the name search is exist in list
        while (true) {            
            nameSearch = InputData.inputString("Enter the student's name that you want to search: ");
            searchList = getListByNameSearch(nameSearch, stuList);
            // check empty list
            if(searchList.isEmpty()){
                System.out.println("Don't have this name in list.");
                System.out.println("Please enter again.");
            }else   break;
        }
        
        Collections.sort(searchList);
        Display.displayFindSortList(searchList);
    }
    
    public static void updateDeleteStudentById(ArrayList<Student> stuList) {
        // check empty list
        if(stuList.isEmpty()){
            System.out.println("The list is empty.");
            System.out.println("Please add information.");
            return;
        }
        
        ArrayList<Student> searchList = new ArrayList<>();
        // loop until find id search in the list
        while (true){            
            String idSearch = InputData.inputString("Enter ID search: ");
            searchList = getListById(idSearch, stuList);
            // check empty list
            if(searchList.isEmpty()){
                System.out.println("This id is not exist in list.");
                System.out.println("Enter again.");
            }else   break;
        }
        
        Display.displaySearchList(searchList);
        int idNumber = 0;
        if(searchList.size() >= 2){
            idNumber = InputData.inputInteger("Enter the number that "
                    + "you want to delete or update: ", 1, searchList.size());
            idNumber -= 1;
        }
        
        Student object = searchList.get(idNumber);
        boolean choice = InputData.inputYN("Do you want to update (U) or delete (D) student: ", "U", "D");
        
        int index = getIndexStudent(object, stuList);
        
        // Update (U) equal true and Delete(D) equal false
        if(choice){
            String idNew;
            String nameNew;
            String semesterNew;
            String courseNew;
            
            stuList.remove(index);
            // loop until user enter legit student's schedule
            while (true) {       
                // loop until user enter legit id and name
                while (true) {                
                    idNew = InputData.inputString("\nEnter new ID: ");
                    nameNew = InputData.inputString("Enter new student's name: ");
                    // check legit id and name (one id has only one name)
                    if(checkDuplicateId(idNew, nameNew, stuList)){
                        System.out.println("This ID was exist with another person.");
                        System.out.println("Enter again.");
                    }else   break;
                }
                
                semesterNew = InputData.inputString("Enter new semester: ");
                courseNew = InputData.inputCourseName("Enter new course name: ");
                // check duplicate student's schedule
                if(checkDuplicateStudent(idNew, semesterNew, courseNew, stuList)){
                    System.out.println("This student's schedule existed.");
                    System.out.println("Enter again");
                }else       break;
            }
            stuList.add(index, new Student(idNew, nameNew, semesterNew, courseNew));
            System.out.println("Update successful!");
        }else{
            stuList.remove(index);
            System.out.println("Delete successful!");
        }
    }
    
    public static void reportStudentTotalCourse(ArrayList<Student> stuList) {
        // check empty list
        if(stuList.isEmpty()){
            System.out.println("The list is empty.");
            System.out.println("Please add information.");
            return;
        }
        
        ArrayList<Student> tempList = new ArrayList<>();
        ArrayList<Report> reportList = new ArrayList();
        tempList.addAll(stuList);
        
        /* loop to access the first object to the last object in list,
        after each loop, we can count the total course of one student */
        for (int i = 0; i < tempList.size(); i++) {
            Student stu1 = tempList.get(i);
            int num = 1;
            // loop to access the second object to the last object in list
            for (int j = i+1; j < tempList.size(); j++) {
                Student stu2 = tempList.get(j);
                // Compare each pair (include id, course) between two objects
                if(stu1.getId().equalsIgnoreCase(stu2.getId())
                        && stu1.getCourse().equalsIgnoreCase(stu2.getCourse())){
                    num++;
                    tempList.remove(j);
                    j--;
                }
            }
            reportList.add(new Report(stu1.getName(), stu1.getCourse(), num));
        }
        Display.displayReportList(reportList);
    }

    public static boolean checkDuplicateId(String id, String name, ArrayList<Student> stuList) {
        // loop to access the first object to the last object
        for (Student obj : stuList) {
            // compare between id, name in input and id, name of each object 
            if(obj.getId().equalsIgnoreCase(id)
                    && !obj.getName().equalsIgnoreCase(name))       return true;
        }
        return false;       
    }
    
    public static boolean checkDuplicateStudent(String id, String semester, String course, ArrayList<Student> stuList) {
        // loop to access the first object to the last object
        for (Student obj : stuList) {
            if(obj.getId().equalsIgnoreCase(id)
                    && obj.getSemester().equalsIgnoreCase(semester)
                    && obj.getCourse().equalsIgnoreCase(course))    return true;
        }
        return false;
    }
    
    public static ArrayList<Student> getListByNameSearch(String nameSearch, ArrayList<Student> stuList) {
        ArrayList<Student> searchList = new ArrayList<>();
        // loop to access the first object to the last object
        for (Student obj : stuList) {
            // compare between name search and name of each object in list
            if(obj.getName().toLowerCase().contains(nameSearch.toLowerCase()))
                searchList.add(new Student(obj.getId(), obj.getName(), obj.getSemester(), obj.getCourse()));
        }
        return searchList;
    }   

    public static ArrayList<Student> getListById(String idSearch, ArrayList<Student> stuList) {
        ArrayList<Student> searchList = new ArrayList<>();
        // loop to access the first object to the last object
        for (Student obj : stuList) {
            if(obj.getId().equalsIgnoreCase(idSearch))
                searchList.add(new Student(obj.getId(), obj.getName(), obj.getSemester(), obj.getCourse()));
        }
        return searchList;
    }
    
    public static int getIndexStudent(Student object, ArrayList<Student> stuList) {
        // loop to access the first object to the last object
        for (int i = 0; i < stuList.size(); i++) {
            // compare between each information of input object and each object in list
            if(stuList.get(i).getId().equalsIgnoreCase(object.getId())
                    && stuList.get(i).getSemester().equalsIgnoreCase(object.getSemester())
                    && stuList.get(i).getCourse().equalsIgnoreCase(object.getCourse()))
                return i;
        }
        return -1;
    }

    
}
