package entity;

public class Courses {
    private int courseID;
    private String coursename;
    private int professorID;
    private int capacity;
    private int availableslots;
    private int credit;

    public Courses(int courseID, String coursename, int professorID, int capacity, int availableslots, int credit) {
        this.courseID = courseID;
        this.coursename = coursename;
        this.professorID = professorID;
        this.capacity = capacity;
        this.availableslots = availableslots;
        this.credit = credit;
    }

    // Getter and Setter methods for each field

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return coursename;
    }

    public void setCourseName(String courseName) {
        this.coursename = courseName;
    }

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableSlots() {
        return availableslots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableslots = availableSlots;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
