package entity;

import java.sql.Date;

public class Professor {
    private int professorID;
    private String Lastname;
    private String Firstname;
    private String District;
    private String Department;
    private Date dob;
    private int phone;
    private int ID;

    public Professor(int professorID, String Lastname, String Firstname, String District, String Department,
                     Date dob, int phone, int ID) {
        this.professorID = professorID;
        this.Lastname = Lastname;
        this.Firstname = Firstname;
        this.District = District;
        this.Department = Department;
        this.dob = dob;
        this.phone = phone;
        this.ID = ID;
    }

    // Getter and Setter methods for each field

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}