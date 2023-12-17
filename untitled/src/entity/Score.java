package entity;

public class Score {
    private int Grade;
    private int studentID;
    private String Testname;
    private String Testyype;
    private int professorID;
    private int courseID;

    public Score(int Grade, int studentID, String Testname, String Testyype, int professorID, int courseID) {
        this.Grade = Grade;
        this.studentID = studentID;
        this.Testname = Testname;
        this.Testyype = Testyype;
        this.professorID = professorID;
        this.courseID = courseID;
    }

    // Getter and Setter methods for each field

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int Grade) {
        this.Grade = Grade;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getTestName() {
        return Testname;
    }

    public void setTestName(String Testname) {
        this.Testname = Testname;
    }

    public String getTestType() {
        return Testyype;
    }

    public void setTestType(String Testyype) {
        this.Testyype = Testyype;
    }

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}