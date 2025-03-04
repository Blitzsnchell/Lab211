package Model;

public class Student implements Comparable<Student>{
    private String id;
    private String name;
    private String semester;
    private String course;

    public Student() {
    }

    public Student(String id, String name, String semester, String course) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void display(){
        System.out.printf("%-10s%-20s%-20s%-20s", id, name, semester, course);
    }
    
    @Override
    public int compareTo(Student o) {
        return this.name.compareToIgnoreCase(o.getName());
    }
    
   
}
