package org.studentmanagement.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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

    public static Student getInstance() {
        if (instance == null) {
            instance = new Student();
        }
        return instance;
    }

    public void setStudentID(String string) {
        this.studentID = string;
    }

    public void setStudentFirstName(String string) {
        this.studentFirstName = string;
    }

    public void setStudentLastName(String string) {
        this.studentLastName = string;
    }

    public void setStudentDOB(String string) {
        this.studentDOB = string;
    }

    public void setStudentMajor(String string) {
        this.studentMajor = string;
    }

    public void setStudentEmail(String string) {
        this.studentEmail = string;
    }

    public void setStudentPhone(String string) {
        this.studentPhone = string;
    }

    public void setStudentAddress(String string) {
        this.studentAddress = string;
    }

    public void setStudentGender(String string) {
        this.studentGender = string;
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

    public String getStudentMajor() {
        return studentMajor;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public String getStudentDOB() {
        return studentDOB;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

}
