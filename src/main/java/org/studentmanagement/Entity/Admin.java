package org.studentmanagement.Entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {
    private static Admin instance = null;

    private String adminID;
    private String adminFirstName;
    private String adminLastName;
    private String adminDOB;
    private String adminGender;
    private String adminAddress;
    private String adminPhone;
    private String adminEmail;

    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin();
        }
        return instance;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getAdminFirstName() {
        return adminFirstName;
    }

    public String getAdminLastName() {
        return adminLastName;
    }

    public String getAdminDOB() {
        return adminDOB;
    }

    public String getAdminGender() {
        return adminGender;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminID(String string) {
        this.adminID = string;
    }

    public void setAdminFirstName(String string) {
        this.adminFirstName = string;
    }

    public void setAdminEmail(String string) {
        this.adminEmail = string;
    }

    public void setAdminPhone(String string) {
        this.adminPhone = string;
    }

    public void setAdminAddress(String string) {
        this.adminAddress = string;
    }

    public void setAdminGender(String string) {
        this.adminGender = string;
    }

    public void setAdminDOB(String string) {
        this.adminDOB  = string;
    }

    public void setAdminLastName(String string) {
        this.adminLastName = string;
    }



}
