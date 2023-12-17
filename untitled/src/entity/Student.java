package entity;

import java.sql.Date;

public class Student {
    private int Phone;
    private Date dob;
    private String address;
    private int studentID;
    private String Firstname;
    private String Lastname;
    private int AcademicYear;
    private int ID;

    // Constructors
    public Student() {
        // Default constructor
    }

    public Student(int Phone, Date dob, String address, int studentID,
                   String Firstname, String Lastname, int AcademicYear, int ID) {
        this.Phone = Phone;
        this.dob = dob;
        this.address = address;
        this.studentID = studentID;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.AcademicYear = AcademicYear;
        this.ID = ID;
    }

    // Getter and Setter methods for Phone
    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    // Getter and Setter methods for dob
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    // Getter and Setter methods for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter methods for studentID
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    // Getter and Setter methods for Firstname
    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    // Getter and Setter methods for Lastname
    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    // Getter and Setter methods for AcademicYear
    public int getAcademicYear() {
        return AcademicYear;
    }

    public void setAcademicYear(int AcademicYear) {
        this.AcademicYear = AcademicYear;
    }

    // Getter and Setter methods for ID
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    // You can add other methods as needed
}
