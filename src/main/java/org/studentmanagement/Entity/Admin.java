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

}
