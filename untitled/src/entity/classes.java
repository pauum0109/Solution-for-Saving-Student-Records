package entity;

import java.sql.Date;

public class classes {
    private int YearTaken;
    private String course_name;
    private Date StarDate;
    private Date EndDate;
    private String building;
    private int professorID;
    private String classroom;
    private int studentID;
    private int courseID;

    public classes(int YearTaken, String course_name, Date StarDate, Date EndDate,
                   String building, int professorID, String classroom,
                   int studentID, int courseID) {
        this.YearTaken = YearTaken;
        this.course_name = course_name;
        this.StarDate = StarDate;
        this.EndDate = EndDate;
        this.building = building;
        this.professorID = professorID;
        this.classroom = classroom;
        this.studentID = studentID;
        this.courseID = courseID;
    }

    // Getter and Setter methods

    public int getYearTaken() {
        return YearTaken;
    }

    public void setYearTaken(int YearTaken) {
        this.YearTaken = YearTaken;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Date getStarDate() {
        return StarDate;
    }

    public void setStarDate(Date StarDate) {
        this.StarDate = StarDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}
