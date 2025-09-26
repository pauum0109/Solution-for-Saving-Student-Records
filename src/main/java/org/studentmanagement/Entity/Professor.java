package org.studentmanagement.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Professor {
    private static Professor instance = null;

    private String professorID;
    private String professorFirstName;
    private String professorLastName;
    private String professorDOB;
    private String professorGender;
    private String professorAddress;
    private String professorPhone;
    private String professorEmail;
    private String professorDepartment;

    public static Professor getInstance() {
        if (instance == null) {
            instance = new Professor();
        }
        return instance;
    }

    public void setProfessorFirstName(String string) {
        this.professorFirstName  = string;
    }

    public void setProfessorDOB(String string) {
        this.professorDOB  = string;
    }

    public void setProfessorDepartment(String string) {
        this.professorDepartment  = string;
    }

    public void setProfessorEmail(String string) {
        this.professorEmail  = string;
    }

    public void setProfessorPhone(String string) {
        this.professorPhone  = string;
    }

    public void setProfessorAddress(String string) {
        this.professorAddress  = string;
    }

    public void setProfessorGender(String string) {
        this.professorGender  = string;
    }

    public void setProfessorLastName(String string) {
        this.professorLastName  = string;
    }

    public void setProfessorID(String string) {
        this.professorID  = string;
    }

    public String getProfessorID() {
        return professorID;
    }
}
