package org.studentmanagement.models;

public class Student {
    private static Student instance = null;

    private String studentID;
    private String studentFirstName;
    private String studentLastName;
    private String studentDOB;
    private String studentGender;
    private String studentAddress;
    private String studentPhone;
    private String studentEmail;
    private String studentMajor;


    private Student() {
    }

    public static Student getInstance() {
        if (instance == null) {
            instance = new Student();
        }
        return instance;
    }

    public static void setInstance(Student instance) {
        Student.instance = instance;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public void setStudentDOB(String studentDOB) {
        this.studentDOB = studentDOB;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public String getStudentDOB() {
        return studentDOB;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getStudentMajor() {
        return studentMajor;
    }
}
