package Model;


public class Report {
    private String name;
    private String course;
    private int totalCourse;

    public Report() {
    }

    public Report(String name, String course, int totalCourse) {
        this.name = name;
        this.course = course;
        this.totalCourse = totalCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }
    
    public void display(){
        System.out.printf("\n%-20s|%-10s|%-5d", name, course, totalCourse);
    }
}
